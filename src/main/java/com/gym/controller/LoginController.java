package com.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    // Show login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Handle login
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        if (username.equals("admin") && password.equals("1234")) {
            return "redirect:/";   // ✅ go to existing home controller
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}