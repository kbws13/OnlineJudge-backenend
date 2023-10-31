package xyz.kbws.judge.codesandbox;

import cn.hutool.core.lang.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.kbws.judge.codesandbox.impl.ExampleCodeSandBox;
import xyz.kbws.judge.codesandbox.model.ExecuteCodeRequest;
import xyz.kbws.judge.codesandbox.model.ExecuteCodeResponse;
import xyz.kbws.model.enums.QuestionSubmitLanguageEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kbws
 * @date 2023/10/31
 * @description:
 */
@SpringBootTest
class CodeSandBoxTest {

    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    void executeCode() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.next();
            CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(type);
            String code = "int main(){}";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputList = Arrays.asList("1 2", "3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
            Assertions.assertNotNull(executeCodeResponse);
        }

    }

    @Test
    void executeCodeByValue() {
        CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(type);
        String code = "int main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        //Assertions.assertNotNull(executeCodeResponse);
    }

    @Test
    void executeCodeByProxy() {
        CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(type);
        codeSandBox = new CodeSandBoxProxy(codeSandBox);
        String code = "int main(){}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        //Assertions.assertNotNull(executeCodeResponse);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.next();
            CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(type);
            String code = "int main(){}";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputList = Arrays.asList("1 2", "3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
            //Assertions.assertNotNull(executeCodeResponse);
        }
    }
}