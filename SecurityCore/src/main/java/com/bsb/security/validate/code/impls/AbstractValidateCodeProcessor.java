package com.bsb.security.validate.code.impls;

import com.bsb.security.validate.code.ValidateCodeGenerator;
import com.bsb.security.validate.code.ValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

public class AbstractValidateCodeProcessor implements ValidateCodeProcessor {

    /**
     * 操作session工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();


    /**
     * 收集系统中所有 {@link com.bsb.security.validate.code.ValidateCodeGenerator} 接口实现
     * @param request
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGeneratorMap;

    @Override
    public void create(ServletWebRequest request) {
//        C
    }
}
