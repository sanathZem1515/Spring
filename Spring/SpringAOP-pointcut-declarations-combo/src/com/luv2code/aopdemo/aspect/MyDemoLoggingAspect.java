package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect
{
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void all(){}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setters(){}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getters(){}

    @Pointcut("all() && !(getters() || setters())")
    private void  allNoGetterNoSetter(){}

    @Before("allNoGetterNoSetter()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("\n =====>>> Executing @before advice on addAccount()");
    }

    @Before("allNoGetterNoSetter()")
    public void performApiAnalytics(){
        System.out.println("\n========>>>>> Performing API analytics");
    }


}
