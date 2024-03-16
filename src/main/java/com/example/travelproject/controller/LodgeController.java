package com.example.travelproject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/lodge")
public class LodgeController {

    @GetMapping({"","/"})
    public String mainLodge(Authentication authentication, Model model){
        log.info("[LodgeController][mainLodge]: Start");
        if (authentication != null){
            model.addAttribute("username", authentication.getName());
            if (authentication.getName().equals("admin")) {
                model.addAttribute("admin", authentication.getName());
            }
        }
        return "lodge/lodgeMain";
    }
}
