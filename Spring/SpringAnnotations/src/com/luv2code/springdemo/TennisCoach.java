package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class TennisCoach implements Coach
{
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(FortuneService theFortuneService)
//    {
//        fortuneService=theFortuneService;
//    }

    public TennisCoach() {
        System.out.println("Tennis Coach : inside default constructor");
    }

//    define my init method

    @PostConstruct
    public void doMyStartupStuff()
    {
        System.out.println("TennisCoach inside of doMyStartupStuff() ..");
    }


    @PreDestroy
    public void doMyCleanupStuff()
    {
        System.out.println("TennisCoach inside of doMyCleanupStuff()");
    }




//    @Autowired
//    public void setFortuneService(FortuneService theFortuneService)
//    {
//        System.out.println("Tennis Coach : inside setFortuneService() method");
//        fortuneService = theFortuneService;
//    }
    @Override
    public String getDailyWorkout() {
        return "Practise your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
