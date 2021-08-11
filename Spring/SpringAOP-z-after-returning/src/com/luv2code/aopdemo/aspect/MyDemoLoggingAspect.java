package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect
{

    @AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAcounts(..))",returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result)
    {
            String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n======>>>>> Executing @AfterReturning on method: "+method);

        System.out.println("\n========>>> result is"+result);
    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.allNoGetterNoSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
    {
        System.out.println("\n =====>>> Executing @before advice on addAccount()");

        //    display the method signature

        MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: "+methoSig);

//        display method arguements

//        get args
        Object[] args = theJoinPoint.getArgs();

//        loop through args nd print
        for(Object tempArg:args)
        {
            System.out.println(tempArg);

            if (tempArg instanceof Account)
            {
                Account theAccount =(Account) tempArg;

                System.out.println("account name: "+theAccount.getName());
                System.out.println("account level "+theAccount.getLevel());
            }
        }
    }



}
