package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp
{
    public static void main(String args[])
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);


        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());


        //call our new methods to get literal values

        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());


        context.close();

    }

}
