package com.example.travelproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.model.repository.UserRepository;
import com.example.travelproject.service.UserService;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    /*
     * 누구나 접근 가능
     */
    @GetMapping({ "/index", "/" })
    public String index(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("menuTitle", "홈");
            return "staff/user";
        }
        return "index";
    }

    @GetMapping("/loginPage")
    public String loginPage(@RequestParam(value = "errorMessage", required = false) String errorMessage, Model model) {

        model.addAttribute("errorMessage", errorMessage);
        return "login/loginPage";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "login/joinPage";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserEntity dto) {

        userService.joinUserDto(dto);
        return "redirect:/loginPage";
    }

    /*
     * 로그인한 경우만
     */
    @GetMapping("/user/index")
    public String user(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        model.addAttribute("menuTitle", "홈");
        return "staff/user";
    }

    @GetMapping("/manager/index")
    public String manager(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        return "staff/manager1";
    }

    @GetMapping("/admin/index")
    public String admin(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        return "staff/admin1";
    }

    @Secured("ADMIN")
    @GetMapping("/secured")
    public String secured(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        return "staff/secured";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    @GetMapping("/secured-roles")
    public String securedRoles(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        return "staff/securedRoles";
    }

    // 아이디찾기 페이지 이동
    @GetMapping("/findIdPage")
    public String findIdPage() {

        return "login/findIdPage";
    }

    @PostMapping("/findId")
    public String findUserId(@ModelAttribute UserEntity dto) {
    userService.
    return "redirect:/loginpage";
    }

}
