package xyz.kbws.judge;

import xyz.kbws.model.entity.QuestionSubmit;

/**
 * @author kbws
 * @date 2023/10/31
 * @description: 判题服务
 */
public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
