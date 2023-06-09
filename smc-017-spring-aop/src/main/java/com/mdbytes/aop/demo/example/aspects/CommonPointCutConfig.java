package com.mdbytes.aop.demo.example.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

    @Pointcut("execution(* com.mdbytes.aop.demo.example.*.*.*(..))")
    public void businessPackageConfig() {}
}
