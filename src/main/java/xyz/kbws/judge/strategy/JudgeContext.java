package xyz.kbws.judge.strategy;

import lombok.Data;
import xyz.kbws.model.dto.question.JudgeCase;
import xyz.kbws.model.dto.questionsubmit.JudgeInfo;
import xyz.kbws.model.entity.Question;
import xyz.kbws.model.entity.QuestionSubmit;

import java.util.List;

/**
 * @author kbws
 * @date 2023/10/31
 * @description: 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
