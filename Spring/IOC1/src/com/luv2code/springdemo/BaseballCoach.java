package com.luv2code.springdemo;

public class BaseballCoach implements Coach
{

    // define a private field for the dependency
    private FortuneService fortuneService;


    public BaseballCoach(FortuneService theFortuneService)
    {
        fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout()
    {
        return "Spend 30 mins on batting practise";
    }

    @Override
    public String getDailyFortune() {
        // use my fortuneService to get a fortune
        return fortuneService.getFortune();
    }
}
