package com.example.demo.rest;

import com.example.demo.service.LoggedUserManagementService;
import com.example.demo.service.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    private String userName;
    private String passWord;


    public LoginProcessor(
                           LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }
    public boolean login() {
        loginCountService.increment();
        String username = this.getUserName();
        String password = this.getPassWord();
        boolean loginResult = false;
        if ("natalie".equals(username) && "password".equals(password)) {
        loginResult = true;
        loggedUserManagementService.setUserName(username);

        }
        return loginResult;
    }

    public String getUserName() {return this.userName;}
    public void setUserName(String userName){this.userName = userName;}

    public String getPassWord() {return this.passWord;}
    public void setPassWord(String passWord){this.passWord = passWord;}
}
