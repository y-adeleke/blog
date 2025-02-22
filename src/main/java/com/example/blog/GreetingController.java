package com.example.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(Model model) {
        String name = "John"; // or retrieve from config, environment, etc.
        LocalTime now = LocalTime.now();
        int hour = now.getHour();

        String greeting;
        if (hour < 12) {
            greeting = "Good Morning, " + name + ", Welcome to COMP367";
        } else {
            greeting = "Good Afternoon, " + name + ", Welcome to COMP367";
        }

        model.addAttribute("greetingMessage", greeting);
        return "index";
    }
}

