package com.bsb.security.validate.code.sms;

import com.bsb.security.validate.code.ValidateCode;
import com.bsb.security.validate.code.impls.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.ServletRequest;

/**
 * @author zeng
 */
@Component("smsCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    @Autowired
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws ServletRequestBindingException {

        String mobile = ServletRequestUtils.getRequiredStringParameter((ServletRequest) request, "mobile");
        smsCodeSender.send(mobile, validateCode.getCode());
    }
}
