package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect
{

    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
    {
        String method = theProceedingJoinPoint.getSignature().toShortString();

        myLogger.info("\n======>>>>> Executing @Around  on method: "+method);

        long begin = System.currentTimeMillis();

        Object result = theProceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();


        long duration = end - begin;


        myLogger.info("\n======> Duration is"+duration/1000.0 +" seconds" );


        return result;
    }






    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint)
    {
        String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("\n======>>>>> Executing @After  (Finally) on method: "+method);
    }




    @AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",throwing= "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc)
    {
        String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("\n======>>>>> Executing @AfterThrowing on method: "+method);

        myLogger.info("\n========>>> The Exception is"+theExc);
    }

    @AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result)
    {
            String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("\n======>>>>> Executing @AfterReturning on method: "+method);

        myLogger.info("\n========>>> result is"+result);
    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.allNoGetterNoSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
    {
        myLogger.info("\n =====>>> Executing @before advice on addAccount()");

        //    display the method signature

        MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();

        myLogger.info("Method: "+methoSig);

//        display method arguements

//        get args
        Object[] args = theJoinPoint.getArgs();

//        loop through args nd print
        for(Object tempArg:args)
        {
            myLogger.info(tempArg.toString());

            if (tempArg instanceof Account)
            {
                Account theAccount =(Account) tempArg;

                myLogger.info("account name: "+theAccount.getName());
                myLogger.info("account level "+theAccount.getLevel());
            }
        }
    }



}
