package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp
{
    public static void main(String args[])
    {

        // read spring config file
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(SportConfig.class);


        //get bean
        SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);


        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

//        call our new methods has the props value injected

        System.out.println("email: "+theCoach.getEmail());
        System.out.println("team: "+theCoach.getTeam());


//        close the context

        context.close();

    }
}
