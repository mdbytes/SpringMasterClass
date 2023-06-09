package com.mdbytes.aop.demo.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformingTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around("com.mdbytes.aop.demo.example.aspects.CommonPointCutConfig.businessPackageConfig()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTimeMillis = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long stopTimeMillis = System.currentTimeMillis();

        long executionDuration =stopTimeMillis - startTimeMillis;

        logger.info("Around aspect - {} method executed in {} ", proceedingJoinPoint,executionDuration);

        return returnValue;
    }
}
