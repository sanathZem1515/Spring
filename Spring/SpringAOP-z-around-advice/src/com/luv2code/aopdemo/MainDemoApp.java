package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp
{
    public static void main(String args[])
    {
//        read spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
//        get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);

        Account myAccount = new Account();
        myAccount.setName("Madhu");
        myAccount.setLevel("Platinum");
//        call the business method

        theAccountDAO.addAccount(myAccount,true);
        theAccountDAO.doWork();

        List<Account> theAccounts = theAccountDAO.findAccounts(false);

        System.out.println("\n\n Main Program : After returning demo APpp");

        System.out.println("-------");

        System.out.println(theAccounts);
        System.out.println("\n");


//        close the context
        context.close();
    }
}
