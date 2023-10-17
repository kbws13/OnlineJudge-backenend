package xyz.kbws.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.kbws.model.dto.question.QuestionQueryRequest;
import xyz.kbws.model.dto.questionsubmit.QuestionSubmitAddRequest;
import xyz.kbws.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import xyz.kbws.model.entity.Question;
import xyz.kbws.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.kbws.model.entity.User;
import xyz.kbws.model.vo.QuestionSubmitVO;
import xyz.kbws.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author hsy
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2023-10-16 21:29:38
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
