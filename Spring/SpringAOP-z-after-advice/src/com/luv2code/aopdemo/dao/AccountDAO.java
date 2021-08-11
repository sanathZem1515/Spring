package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class AccountDAO
{
    private String name;
    private String serviceCode;

    public void addAccount(Account theAccount,boolean check)
    {
        System.out.println(getClass() +"DOING MY DB WORK ADDING AN ACCOUNT!");
    }

    public boolean doWork(){
        System.out.println(getClass()+"doing work");
        return  false;
    }

    public List<Account> findAccounts(boolean tripWire)
    {

        if(tripWire)
        {
            throw new RuntimeException("No soup for you");
        }
        List<Account> myAccounts = new ArrayList<>();

//        create sample accounts

        Account temp1 = new Account("John","silver");
        Account temp2 = new Account("Madhu","platinum");
        Account temp3 = new Account("Luca","gold");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }
}
