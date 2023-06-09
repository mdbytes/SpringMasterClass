package com.mdbytes.aop.demo.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("com.mdbytes.aop.demo.example.aspects.CommonPointCutConfig.businessPackageConfig()")
    public void logMethodCallBefore(JoinPoint joinPoint) {
        // Logic - what to do?
        logger.info("Before Aspect.  Method is called - {} with arguments {}",joinPoint, joinPoint.getArgs());
    }

    @After("com.mdbytes.aop.demo.example.aspects.CommonPointCutConfig.businessPackageConfig()")
    public void logMethodCallAfter(JoinPoint joinPoint) {
        // Logic - what to do?
        logger.info("After Aspect.  Method is called - {} with arguments {}",joinPoint, joinPoint.getArgs());
    }

    @AfterThrowing("com.mdbytes.aop.demo.example.aspects.CommonPointCutConfig.businessPackageConfig()")
    public void logMethodCallAfterException(JoinPoint joinPoint) {
        // Logic - what to do?
        logger.info("After Aspect.  Method exception - {} with arguments {}",joinPoint, joinPoint.getArgs());
    }

    @AfterReturning("com.mdbytes.aop.demo.example.aspects.CommonPointCutConfig.businessPackageConfig()")
    public void logMethodCallAfterReturning(JoinPoint joinPoint) {
        // Logic - what to do?
        logger.info("After Aspect.  Method return made - {} with arguments {}",joinPoint, joinPoint.getArgs());
    }

}
