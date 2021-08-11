package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LuvAopExpressions
{
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void all(){}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void setters(){}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void getters(){}

    @Pointcut("all() && !(getters() || setters())")
    public void  allNoGetterNoSetter(){}

}
