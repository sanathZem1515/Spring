package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import lombok.Data;
import org.springframework.stereotype.Component;

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
}
