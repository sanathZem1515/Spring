package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp
{
    public static void main(String args[])
    {

        // read spring config file
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");


        //get bean
        Coach theCoach = context.getBean("tennisCoach",Coach.class);


        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

//        close the context

        context.close();

    }
}
