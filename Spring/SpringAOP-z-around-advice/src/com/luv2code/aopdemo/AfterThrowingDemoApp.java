package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp
{
    public static void main(String args[])
    {
//        read spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
//        get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);


        List<Account> theAccounts = null;


        try{
//            add a flag to simulate exception

            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        }
        catch (Exception exc)
        {
            System.out.println("\n\n\n Main program exception"+exc);
        }

        System.out.println("\n\n Main Program : After throwing demo APpp");

        System.out.println("-------");

        System.out.println(theAccounts);
        System.out.println("\n");


//        close the context
        context.close();
    }
}
