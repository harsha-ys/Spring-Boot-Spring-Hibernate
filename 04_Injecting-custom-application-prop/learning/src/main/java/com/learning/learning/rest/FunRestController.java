package com.learning.learning.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${team.name}")
    public String teamName;

    @Value("${batsman.openbatter}")
    public String openBatter;

    @GetMapping("/")
    public String sayHellow(){
        return "Hellow Worldk";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5kvvv!";
    }

    @GetMapping("/cricketTeam")
    public String getTeamDetails(){
        return "Team : "+ teamName + " , open batter : " + openBatter;
    }

}
