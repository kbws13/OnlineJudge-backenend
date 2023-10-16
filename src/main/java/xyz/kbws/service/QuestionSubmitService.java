package xyz.kbws.service;

import xyz.kbws.model.dto.questionsubmit.QuestionSubmitAddRequest;
import xyz.kbws.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.kbws.model.entity.User;

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

}
