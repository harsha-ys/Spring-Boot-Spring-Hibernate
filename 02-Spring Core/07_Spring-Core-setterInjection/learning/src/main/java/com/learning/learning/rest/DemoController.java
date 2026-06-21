package com.learning.learning.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    ICoach myCoach;

    @Autowired
    public void setMyCoach(ICoach coach){
        myCoach = coach;
    }

    @GetMapping("/dailyWorkoutsd")
    public String getDailyWorkouts(){
        return myCoach.getDailyWorkout();
    }

}
