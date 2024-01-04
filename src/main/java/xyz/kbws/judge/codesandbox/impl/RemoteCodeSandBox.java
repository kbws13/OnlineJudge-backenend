package xyz.kbws.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import xyz.kbws.common.ErrorCode;
import xyz.kbws.exception.BusinessException;
import xyz.kbws.judge.codesandbox.CodeSandBox;
import xyz.kbws.judge.codesandbox.model.ExecuteCodeRequest;
import xyz.kbws.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author kbws
 * @date 2023/10/31
 * @description: 远程代码沙箱
 */
public class RemoteCodeSandBox implements CodeSandBox {

    // 定义鉴权请求头和密钥
    public static final String AUTH_REQUEST_HEADER = "auth";

    public static final String AUTH_REQUEST_SECRET = "secret";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        //String url = "http://localhost:8090/executeCode";
        String url = "http://codesandbox.kbws.xyz/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
