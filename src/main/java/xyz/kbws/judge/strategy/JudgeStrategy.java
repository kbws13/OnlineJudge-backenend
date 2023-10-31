package xyz.kbws.judge.strategy;

import xyz.kbws.model.dto.questionsubmit.JudgeInfo;

/**
 * @author kbws
 * @date 2023/10/31
 * @description: 判题策略
 */
public interface JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
