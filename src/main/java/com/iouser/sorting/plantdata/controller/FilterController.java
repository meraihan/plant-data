package com.iouser.sorting.plantdata.controller;

import com.iouser.sorting.plantdata.repository.DamageRepository;
import com.iouser.sorting.plantdata.repository.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/filter-data")
public class FilterController {

    @Autowired
    GeneralRepository generalRepository;

    @GetMapping("/list")
    public String findData(Model model){
        model.addAttribute("plantList", generalRepository.findAll());
        return "data/filter_view";
    }
}
