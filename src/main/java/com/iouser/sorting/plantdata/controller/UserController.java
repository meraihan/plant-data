package com.iouser.sorting.plantdata.controller;

import com.iouser.sorting.plantdata.model.User;
import com.iouser.sorting.plantdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        return "user/add";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, final RedirectAttributes redirectAttributes) {
        if (userService.addUser(user)) {
            redirectAttributes.addFlashAttribute("success", "User registration successful");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("error", "user registration failed");
            return "redirect:/user/register";
        }
    }

}
