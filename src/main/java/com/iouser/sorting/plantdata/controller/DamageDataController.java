package com.iouser.sorting.plantdata.controller;

import com.iouser.sorting.plantdata.repository.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/damage-data")
public class DamageDataController {

    @Autowired
    DamageRepository damageRepository;

    @GetMapping("/list")
    public String findData(Model model){
        model.addAttribute("damages", damageRepository.findAll());
        return "data/damage";
    }
}
