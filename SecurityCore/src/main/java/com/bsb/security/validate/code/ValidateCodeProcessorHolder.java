/**
 * 
 */
package com.bsb.security.validate.code;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zeng
 *
 */
@Component
public class ValidateCodeProcessorHolder {

	@Autowired
	private Map<String, ValidateCodeProcessor> validateCodeProcessors;

	public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
		System.out.println("寻找type bean" + type);
		return findValidateCodeProcessor(type.toString().toLowerCase());
	}

	public ValidateCodeProcessor findValidateCodeProcessor(String type) {
		System.out.println("interface " + ValidateCodeProcessor.class.getSimpleName());
		String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
		System.out.println("name " + name);
		ValidateCodeProcessor processor = validateCodeProcessors.get(name);
		if (processor == null) {
			System.out.println("即将抛异常");
			throw new ValidateCodeException("验证码处理器" + name + "不存在");
		}
		System.out.println("已找到存在的验证码处理器");
		return processor;
	}

}
