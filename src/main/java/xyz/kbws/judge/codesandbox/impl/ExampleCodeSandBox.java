package xyz.kbws.judge.codesandbox.impl;

import xyz.kbws.judge.codesandbox.CodeSandBox;
import xyz.kbws.judge.codesandbox.model.ExecuteCodeRequest;
import xyz.kbws.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author kbws
 * @date 2023/10/31
 * @description: 示例代码沙箱
 */
public class ExampleCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("示例代码沙箱");
        return null;
    }
}
