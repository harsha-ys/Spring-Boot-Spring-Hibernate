package com.example.demo.rest;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements ICoach{
    @Override
    public String getDailyWorkout() {
        return "Train swings 30 mins a day:";
    }
}
