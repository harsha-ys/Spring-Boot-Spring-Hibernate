package com.example.demo.rest;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach{
    @Override
    public String getDailyWorkout() {
        return "Run 15 minutes a day:";
    }
}
