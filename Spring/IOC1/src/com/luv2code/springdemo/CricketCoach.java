package com.luv2code.springdemo;

public class CricketCoach implements Coach
{

    private FortuneService fortuneService;
    private String email,team;


    public CricketCoach()
    {
        System.out.println("CricketCoach : inside no-arg constructor");
    }

    public void setFortuneService(FortuneService theFortuneService)
    {
        System.out.println("CricketCoach : inside setter");
        this.fortuneService = theFortuneService;
    }

    public void setEmail(String email)
    {
        System.out.println("CricketCoach : inside setEmail");
        this.email=email;
    }

    public void setTeam(String team)
    {
        System.out.println("CricketCoach : inside setTeam");
        this.team = team;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getTeam()
    {
        return this.team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practise bowling for 30 min";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
