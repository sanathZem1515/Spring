package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalysticsAspect
{
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.allNoGetterNoSetter()")
    public void performApiAnalytics(){
        System.out.println("\n========>>>>> Performing API analytics");
    }

}
