package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp
{
    public static void main(String args[])
    {
        //load spring config
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("beanScope-applicationContext.xml");



        //retrieve bean from spring container

        Coach theCoach = context.getBean("myCoach",Coach.class);


        Coach alphaCoach = context.getBean("myCoach",Coach.class);

        boolean result = (theCoach==alphaCoach);

        System.out.println("\n pointing to the same object: "+ result);

        System.out.println("\n Memory loaction for theCoach: "+theCoach);

        System.out.println("\n Memory loaction for theCoach: "+alphaCoach);
    }
}
