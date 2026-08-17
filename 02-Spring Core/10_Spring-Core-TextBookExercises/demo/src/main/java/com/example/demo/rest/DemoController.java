package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DemoController {

    @RequestMapping("/home")
    public String home(@RequestParam(required = false) String color, @RequestParam(required = false) String name, Model page){
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";
    }

}
