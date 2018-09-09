package com.bsb.code;

import com.bsb.security.validate.code.ImageCode;
import com.bsb.security.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 如需要使用更高级别的验证码生成器则使用Component注解并声明id这样就会加载这个Bean不会再走低级的图形验证码
 * 以增量的方式适应变化，遵循设计模式的开闭原则
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode createImageCode(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
