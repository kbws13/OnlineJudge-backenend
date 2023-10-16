package xyz.kbws.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.kbws.model.dto.question.QuestionQueryRequest;
import xyz.kbws.model.entity.Question;
import xyz.kbws.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.kbws.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author hsy
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2023-10-16 21:27:46
*/
public interface QuestionService extends IService<Question> {
    /**
     * 校验
     *
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * 获取题目封装
     *
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * 分页获取题目封装
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
}
