package com.example.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemoController {

    @RequestMapping("/dhome/{color}")
    public String home(@PathVariable String color, Model page){
        page.addAttribute("username", "Yoshith");
        page.addAttribute("color", color);
        return "home.html";
    }

}
