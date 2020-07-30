package com.chenglong.test1.aspect;

import com.chenglong.test1.controller.ParamController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    private final static Logger logger = LoggerFactory.getLogger(MyAspect.class);

    @Pointcut("execution(public * com.chenglong.test1.controller.*.*(..))")
    public void myPointCut(){}

    @Around(value = "myPointCut()")
    public Object arround(ProceedingJoinPoint pjp){
        try {
            logger.info("1、Around：方法环绕开始.....");
            Object o =  pjp.proceed();
            logger.info("3、Around：方法环绕结束，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            logger.error(pjp.getSignature() + " 出现异常： ", e);
            return null;
        }
    }

}
