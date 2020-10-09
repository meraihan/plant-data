package com.iouser.sorting.plantdata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iouser.sorting.plantdata.model.*;
import com.iouser.sorting.plantdata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    FilterPlantRepository filterPlantRepository;
    @Autowired
    FilterPlantRepositoryWithJdbc filterPlantRepositoryWithJdbc;
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("plantList", generalRepository.findAll());
        return "data/filter_view";
    }
    @GetMapping("/filter_view")
    public String filterView(Model model) throws JsonProcessingException {
        return "data/filter_view";
    }



    @PostMapping("/save_filter_data")
    public String insert(@ModelAttribute("filterPlant") FilterPlant filterPlant, final RedirectAttributes redirectAttributes) {
        String specialLevel = "";
        String damageLevel = "";
        FilterPlant fp = new FilterPlant();
        User user = new User();
        user.setId(1L);
        fp.setUser(user);
        fp.setPlantId(filterPlant.getPlantId());

//        model.addAttribute("plant",filterPlantRepository.save(filterPlant));
        redirectAttributes.addFlashAttribute("success", "General Data Added successful");
        return "redirect:/general-data/list";
    }
}
