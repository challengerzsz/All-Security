package com.bsb.security.validate.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/code")
public class ValidateCodeController {

//    @Autowired
//    private Map<String, ValidateCodeProcessor> validateCodeProcessors;
    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        logger.info("type {}", type);
//        ValidateCodeProcessor validateCodeProcessor = validateCodeProcessors.get(type + "CodeProcessor");
//        validateCodeProcessor.create(new ServletWebRequest(request, response));
        validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
        System.out.println("validate controller finished");
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
