package com.luv2code.springdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect
{
//    setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());
//    setup pointcut declarations

    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow(){}

//add @Before advice

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
//        display method
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>>> in @Before : calling method "+theMethod);
//        display the args

        Object[] args = theJoinPoint.getArgs();

        for(Object tempArg :args)
        {
            myLogger.info("=====> arguement "+tempArg);
        }
    }


//    add @After Returning advice

    @AfterReturning(pointcut = "forAppFlow()",returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint,Object theResult)
    {
//        display method
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>>> in @Before : calling method "+theMethod);

//        display data returned

        myLogger.info("=======> the result is "+theResult);

    }

}
