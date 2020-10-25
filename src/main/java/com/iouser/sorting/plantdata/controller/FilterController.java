package com.iouser.sorting.plantdata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iouser.sorting.plantdata.model.*;
import com.iouser.sorting.plantdata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/filter-data")
public class FilterController {

    @Autowired
    GeneralRepository generalRepository;
    @Autowired
    FilterPlantRepositoryWithJdbc filterPlantRepositoryWithJdbc;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("plantList", generalRepository.findAll());
        return "data/filter_view";
    }
    @GetMapping("/filter_view/{isFilter}")
    public String filterView(@PathVariable("isFilter") Boolean isfilter,  Model model) {
        model.addAttribute("isFilter",isfilter);
        return "data/filter_view";
    }


    @GetMapping("/filter_plant_list")
    public String filterPlantList(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username =null;
        if (principal instanceof UserDetails){
            username = ((UserDetails) principal).getUsername();
        }
        List<Plant> plantList = filterPlantRepositoryWithJdbc.findByUsername(username);
        model.addAttribute("filterPlantList",plantList);
        return "data/filter_plant_list";
    }
}
