package com.luv2code.aopdemo;

import com.luv2code.aopdemo.service.TrafficFortuneservice;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp
{

    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
    public static void main(String args[])
    {
//        read spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
//        get the bean from spring container
        TrafficFortuneservice theFortuneService = context.getBean("trafficFortuneservice",TrafficFortuneservice.class);

        myLogger.info("\n Main program : AroundDemoApp");

        myLogger.info("Calling Get fortune");

        String data = theFortuneService.getFortune();

        myLogger.info("\n My fortune is "+data);

        myLogger.info("Finished");

//        close the context
        context.close();
    }
}
