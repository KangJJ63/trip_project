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
        log.info("[LodgeController][mainPlan]: Start");
        if (authentication.getName().equals("admin")) {
            model.addAttribute("admin", authentication.getName());
        }
        return "plan/planMain";
    }
}
