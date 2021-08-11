package com.luv2code.aopdemo;

import lombok.Data;


@Data
public class Account
{

    private String name;
    private String level;

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public Account() {
    }
}
