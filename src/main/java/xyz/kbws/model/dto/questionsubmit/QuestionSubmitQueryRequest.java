package xyz.kbws.model.dto.questionsubmit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.kbws.common.PageRequest;

import java.io.Serializable;

/**
 * 查询请求
 *
 * @author kbws
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    /**
     * 题目 id
     */
    private Long questionId;


    /**
     * 提交状态
     */
    private Integer status;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户id
     */
    private String userId;

    private static final long serialVersionUID = 1L;
}