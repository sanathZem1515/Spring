package com.luv2code.springdemo.gofoodie.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AspectLogging {

    private static Logger myLogger = Logger.getLogger(AspectLogging.class.getName());

    @Before("com.luv2code.springdemo.gofoodie.aspect.AspectExpressions.find()")
    public void beforeFind(){
       myLogger.info("\n =====>>>> Finding from the service layer using repository");
    }

    @After("com.luv2code.springdemo.gofoodie.aspect.AspectExpressions.find()")
    public void afterGenerateQuiz(){
        myLogger.info("\n =====>>>> Found from the service layer using repository");
    }

    @Before("com.luv2code.springdemo.gofoodie.aspect.AspectExpressions.save()")
    public void beforeChangeRole(){
        myLogger.info("\n =====>>>> Saving to the db from the service layer using repository");
    }

    @AfterReturning("com.luv2code.springdemo.gofoodie.aspect.AspectExpressions.save()")
    public void afterChangeRole(){
        myLogger.info("\n =====>>>> Saving to the db from the service layer using repository");
    }

}

