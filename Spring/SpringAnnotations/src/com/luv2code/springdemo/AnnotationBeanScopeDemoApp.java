package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp
{
    public static void main(String args[])
    {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");


        //get bean
        Coach theCoach = context.getBean("tennisCoach",Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach",Coach.class);


        boolean result = (theCoach==alphaCoach);

        System.out.println("\n Pointing the same object: "+result);

        System.out.println("\n Memory Location: "+theCoach );

        System.out.println("\n Memory Location: "+alphaCoach );

//        close the context
        context.close();
    }
}
