package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
//        call the business method

        theAccountDAO.addAccount(myAccount,true);
        theAccountDAO.doWork();

//        calling setters and getters

        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name= theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
//        do it again

//        call teh business method again
        theMembershipDAO.addSillyAccount();
        theMembershipDAO.goToSleep();

//        close the context
        context.close();
    }
}
