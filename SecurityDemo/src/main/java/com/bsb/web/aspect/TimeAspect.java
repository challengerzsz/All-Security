package com.bsb.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimeAspect {

    /**
     * 切点是UserController类中一些方法(任意返回值，参数不固定)
     * @param proceedingJoinPoint 可以取到控制器接收的参数
     * @return
     * @throws Throwable
     */
    //todo 过滤器 拦截器 切片
    @Around("execution(* com.bsb.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("time aspect start");

        Object[] args = proceedingJoinPoint.getArgs();
        for (Object temp : args) {
            System.out.println("arg is " + temp);
        }

        long start = new Date().getTime();

        Object object = proceedingJoinPoint.proceed();

        System.out.println("time aspect 耗时" + (new Date().getTime() - start));

        System.out.println("time aspect end");

        return object;
    }

}
