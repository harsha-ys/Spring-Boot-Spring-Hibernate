package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    @Qualifier("tennisCoach")
    private ICoach myCoach;

//    @Autowired
//    public void setMyCoach(ICoach coach){
//        myCoach = coach;
//    }
    @GetMapping("/dailyWorkouts")
    public String getDailyWorkouts(){
        return myCoach.getDailyWorkout();
    }

}
