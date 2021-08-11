package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneservice;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp
{
    public static void main(String args[])
    {
//        read spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
//        get the bean from spring container
        TrafficFortuneservice theFortuneService = context.getBean("trafficFortuneservice",TrafficFortuneservice.class);

        System.out.println("\n Main program : AroundDemoApp");

        System.out.println("Calling Get fortune");

        String data = theFortuneService.getFortune();

        System.out.println("\n My fortune is "+data);

        System.out.println("Finished");




//        close the context
        context.close();
    }
}
