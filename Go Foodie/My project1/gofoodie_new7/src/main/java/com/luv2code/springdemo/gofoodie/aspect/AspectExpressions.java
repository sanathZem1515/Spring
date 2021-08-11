package com.luv2code.springdemo.gofoodie.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AspectExpressions {
    @Pointcut("execution(* com.luv2code.springdemo.gofoodie.service.*.find*(..))")
    public void find() {
//        method declared to use in aspectLogging class
    }

    @Pointcut("execution(* com.luv2code.springdemo.gofoodie.service.*.save*(..))")
    public void save() {
        //        method declared to use in aspectLogging class
    }

}
