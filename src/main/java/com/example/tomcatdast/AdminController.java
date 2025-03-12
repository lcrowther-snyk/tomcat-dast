package com.example.tomcatdast;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public String admin(HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user != null) {
            return "Welcome to the admin page, " + user + "!";
        } else {
            return "You are not logged in. <a href='/'>Go to Login Page</a>";
        }
    }
}