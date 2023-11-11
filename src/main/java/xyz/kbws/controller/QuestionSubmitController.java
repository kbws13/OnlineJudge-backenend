package xyz.kbws.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.kbws.annotation.AuthCheck;
import xyz.kbws.common.BaseResponse;
import xyz.kbws.common.ErrorCode;
import xyz.kbws.common.ResultUtils;
import xyz.kbws.constant.UserConstant;
import xyz.kbws.exception.BusinessException;
import xyz.kbws.model.dto.questionsubmit.QuestionSubmitAddRequest;
import xyz.kbws.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import xyz.kbws.model.entity.QuestionSubmit;
import xyz.kbws.model.entity.User;
import xyz.kbws.model.vo.QuestionSubmitVO;
import xyz.kbws.service.QuestionSubmitService;
import xyz.kbws.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
@Deprecated
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    ///**
    // * 提交题目
    // *
    // * @param questionSubmitAddRequest
    // * @param request
    // * @return BaseResponse
    // */
    //@PostMapping("/")
    //public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
    //                                           HttpServletRequest request) {
    //    if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
    //        throw new BusinessException(ErrorCode.PARAMS_ERROR);
    //    }
    //    // 登录才能点赞
    //    final User loginUser = userService.getLoginUser(request);
    //    long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
    //    return ResultUtils.success(questionSubmitId);
    //}
    //
    ///**
    // * 分页获取题目提交列表（除管理员外，其他用户只能看到非答案、提交代码等公开信息）
    // *
    // * @param questionSubmitQueryRequest
    // * @param request
    // * @return
    // */
    //@PostMapping("/list/page")
    //@AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    //public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmit(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
    //                                                               HttpServletRequest request) {
    //    long current = questionSubmitQueryRequest.getCurrent();
    //    long size = questionSubmitQueryRequest.getPageSize();
    //    Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
    //            questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
    //    final User loginUser = userService.getLoginUser(request);
    //    return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    //}

}
