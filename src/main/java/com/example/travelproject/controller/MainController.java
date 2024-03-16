package com.example.travelproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.travelproject.model.dao.UserDao;
import com.example.travelproject.model.entity.UserEntity;
import com.example.travelproject.model.repository.UserRepository;
import com.example.travelproject.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    /*
     * 누구나 접근 가능
     */
    @GetMapping({ "/index", "/" })

    public String index(Authentication authentication, Model model) {
        if (authentication == null || userRepository.getUserDtoById(authentication.getName()) == null) {
            return "index";
        }
        if (authentication.getName().equals("admin")) {
            return "admin/index";
        } else {
            log.info("[user]: " + authentication);
            return "user/index";
        }
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

    @PostMapping("/findPw")
    public String findPwd(@ModelAttribute UserEntity entity, Model model) {
        log.info("[find_pw1]: " + entity);
        log.info("[find_pw1-1]: " + userRepository.getUserDtoById(entity.getUserId()));
        if (userRepository.getUserDtoById(entity.getUserId()) == null) {
            log.info("가입된 아이디가 아닌 경우에...");
            return "/"; // 가입된 아이디가 아닙니다. 출력하는 방법?
        }
        model.addAttribute("userId", entity.getUserId());
        log.info("[find_pw1-2]: " + model);
        return "login/findPw";
    }

    @PostMapping("/findPw2")
    public String findPw2(@ModelAttribute UserEntity entity, Authentication authentication) {
        log.info("[find_pw2]: " + entity);
        log.info("[find_pw2-2]: " + userRepository.getUserDtoById(entity.getUserId()));

        userService.updateUserDto(entity);
        if (authentication != null) {
            authentication.setAuthenticated(false);
            log.info("[find_pw2-3][auth]: " + authentication);
        }

        return "redirect:/loginPage";
    }

    @PostMapping("/ConfirmId") // Id 중복확인
    @ResponseBody
    public ResponseEntity<Boolean> confirmId(String id) {
        log.info("[MainController][ConfirmId] Start: " + id);
        boolean result = true;

        if (id.trim().isEmpty()) { // 입력된 Id가 비어있는 경우
            log.info("[ConfirmId][공백ID] >>> " + id);
            result = false;
        } else {
            log.info("[ConfirmId][저장된 ID] >>> " + userRepository.getUserDtoById(id));
            if (userRepository.getUserDtoById(id) != null) {
                result = false; // 저장된 ID가 있다면 false -> 중복
            } else {
                result = true;
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    // Email 중복확인 by 성민
    @PostMapping("/ConfirmEmail")
    @ResponseBody
    public ResponseEntity<Boolean> confirmEmail(String email) {
        log.info("[MainController][confirmEmail] Start: " + email);
        boolean result = true;

        if (email.trim().isEmpty()) {
            result = false;
        } else {
            if (userDao.findByUserEmail(email) != null) {
                result = false; // 저장된 Email이 있다면 false -> 중복
            } else {
                result = true;
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /*
     * 로그인한 경우만
     */
    @GetMapping("/user/index")

    public String user(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("username", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
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
        model.addAttribute("admin", userRepository.getUserDtoById(userDetails.getUsername()).getUserNm());
        return "staff/user";
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

    @GetMapping("/admin/setting")
    public String adminSetting(Authentication authentication, Model model) {
        model.addAttribute("admin", authentication.getName());
        model.addAttribute("userlist", userRepository.findAll());
        log.info("[admin]: " + userRepository.findAll());

        return "staff/admin1";
    }

    // 아이디찾기 페이지 이동
    @GetMapping("/findIdPage")
    public String findIdPage(@RequestParam(value = "erroMessage", required = false) String errorMessage, Model model) {
        model.addAttribute("errorMessage", errorMessage);
        return "login/findIdPage";
    }

    @GetMapping("/findId")
    public String findUserId(String userNm, String userEmail, Model model) {
        log.info("[MainController][findUserId] " + userNm + userEmail);
        UserEntity entity = userRepository.getUserIdByEmail(userNm, userEmail);
        if (entity != null) {
            model.addAttribute("userId", entity.getUserId());
            return "login/userIdPage";
        } else {
            model.addAttribute("errorMessage", "아이디를 찾을 수 없습니다.");
            return "login/findIdPage";
        }
    }

}