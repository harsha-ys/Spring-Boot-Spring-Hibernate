package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedUserManagementService {
    private String userName;

    public String getUserName() {return this.userName;}
    public void setUserName(String userName){this.userName = userName;}
}
