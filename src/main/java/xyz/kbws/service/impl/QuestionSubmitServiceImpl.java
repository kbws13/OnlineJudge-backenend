package xyz.kbws.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.aop.framework.AopContext;
import org.springframework.transaction.annotation.Transactional;
import xyz.kbws.common.ErrorCode;
import xyz.kbws.exception.BusinessException;
import xyz.kbws.model.dto.questionsubmit.JudgeInfo;
import xyz.kbws.model.dto.questionsubmit.QuestionSubmitAddRequest;
import xyz.kbws.model.entity.Question;
import xyz.kbws.model.entity.QuestionSubmit;
import xyz.kbws.model.entity.QuestionSubmit;
import xyz.kbws.model.entity.User;
import xyz.kbws.service.QuestionService;
import xyz.kbws.service.QuestionSubmitService;
import xyz.kbws.service.QuestionSubmitService;
import xyz.kbws.mapper.QuestionSubmitMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hsy
 * @description 针对表【question_submit(题目提交)】的数据库操作Service实现
 * @createDate 2023-10-16 21:29:38
 */
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
        implements QuestionSubmitService {

    @Resource
    QuestionService questionService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        // TODO 校验编程语言是否合法
        long questionId = questionSubmitAddRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已提交题目
        long userId = loginUser.getId();
        // 每个用户串行提交题目
        QuestionSubmit questionSubmit1 = new QuestionSubmit();
        questionSubmit1.setUserId(userId);
        questionSubmit1.setQuestionId(questionId);
        questionSubmit1.setCode(questionSubmitAddRequest.getCode());
        questionSubmit1.setLanguage(questionSubmitAddRequest.getLanguage());
        // TODO 设置初始状态
        questionSubmit1.setStatus(0);
        questionSubmit1.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit1);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据插入异常");
        }
        return questionSubmit1.getId();
    }

}




