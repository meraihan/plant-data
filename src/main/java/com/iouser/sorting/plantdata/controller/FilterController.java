package com.iouser.sorting.plantdata.controller;

import com.iouser.sorting.plantdata.model.Plant;
import com.iouser.sorting.plantdata.repository.DamageRepository;
import com.iouser.sorting.plantdata.repository.GeneralRepository;
import com.iouser.sorting.plantdata.repository.SpecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/filter-data")
public class FilterController {

    @Autowired
    GeneralRepository generalRepository;
    @Autowired
    SpecialRepository specialRepository;
    @Autowired
    DamageRepository damageRepository;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("plantList", generalRepository.findAll());
        return "data/filter_view";
    }

    @GetMapping("/filter_view")
    public String filterView(@RequestParam("id") Long id, Model model){
//        Optional<Plant> plant = generalRepository.findById(id);
        model.addAttribute("plant",generalRepository.findById(id));
        model.addAttribute("special", damageRepository.findById(id));
        return "data/filter_view";
    }
}
