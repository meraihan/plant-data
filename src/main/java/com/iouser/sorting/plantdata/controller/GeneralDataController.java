package com.iouser.sorting.plantdata.controller;

import com.iouser.sorting.plantdata.repository.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/general-data")
public class GeneralDataController {

    @Autowired
    GeneralRepository generalRepository;

    @GetMapping("/list")
    public String findData(Model model){
        model.addAttribute("generals", generalRepository.findAll());
        return "data/general";
    }

}
