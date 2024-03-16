package com.example.travelproject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/plan")
public class PlanController {

    @GetMapping({"","/"})
    public String mainPlan(Authentication authentication, Model model){
<<<<<<< HEAD
        log.info("[LodgeController][mainPlan]: Start");
        if (authentication.getName().equals("admin")) {
            model.addAttribute("admin", authentication.getName());
=======

        if (authentication != null) {
            model.addAttribute("username", authentication.getName());
            if (authentication.getName().equals("admin")) {
                model.addAttribute("admin", authentication.getName());
            }
>>>>>>> 5dc288253579a96b3c79ddab6da27c8bac9e9287
        }
        return "plan/planMain";
    }
}
