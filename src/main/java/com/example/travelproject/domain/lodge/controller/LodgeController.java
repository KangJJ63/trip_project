package com.example.travelproject.domain.lodge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lodge")
public class LodgeController {

    @GetMapping({"","/"})
    public String mainLodge(Model model){
        model.addAttribute("menuTitle","숙박");
        return "lodge/lodgeMain";
    }
}
