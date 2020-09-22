package com.iouser.sorting.plantdata.controller;

import com.iouser.sorting.plantdata.repository.SpecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/special-data")
public class SpecialDataController {

    @Autowired
    SpecialRepository specialRepository;


    @GetMapping("/list")
    public String findData(Model model){
        model.addAttribute("specials", specialRepository.findAll());
        return "data/special";
    }

}
