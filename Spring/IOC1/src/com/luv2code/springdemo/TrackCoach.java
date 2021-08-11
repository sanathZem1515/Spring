package com.luv2code.springdemo;

public class TrackCoach implements Coach
{

    private FortuneService fortuneService;

    public TrackCoach(FortuneService theFortuneService)
    {
        fortuneService=theFortuneService;
    }

    public TrackCoach() {
    }

    @Override
    public String getDailyWorkout()
    {
        return "Run a hard 5K";
    }

    @Override
    public String getDailyFortune() {
        return "Just do It "+fortuneService.getFortune();
    }


    // add an init method

    public void doMyStartupStuff() {
        System.out.println("Track coach: inside method doMyStartupStuff");
    }

    // add an destroy method

    public void doMyCleanupStuff()
    {
        System.out.println("Track coach: inside method doMyCleanupStuff");
    }
}
