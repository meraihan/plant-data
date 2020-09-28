package com.iouser.sorting.plantdata.controller;

import com.iouser.sorting.plantdata.model.Plant;
import com.iouser.sorting.plantdata.repository.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/add")
    public String add(@ModelAttribute("general") Plant plant, Model model) {
        model.addAttribute("plant",plant);
        return "data/gen_add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("general") Plant plant,Model model, final RedirectAttributes redirectAttributes) {
        if (generalRepository.save(plant)!=null) {
            redirectAttributes.addFlashAttribute("success", "General Data Added successful");
            return "redirect:/general-data/list";
        } else {
            redirectAttributes.addFlashAttribute("error", "General Data Add Failed");
            model.addAttribute("plant",plant);
            return "redirect:add";
        }
    }

    @GetMapping("/update")
    public String update(@ModelAttribute("general") Plant plant, Model model) {
//        Plant plant1 = generalRepository.findByPlants(plant.getPlantName()).get();
//        model.addAttribute("findGeneralDataById", plant1);
        return "data/gen_update";
    }

    @PostMapping("/update")
    public String edit(@ModelAttribute("general") Plant general, final RedirectAttributes redirectAttributes) {
       if (generalRepository.save(general)!=null) {
                redirectAttributes.addFlashAttribute("success", "general data updated successfully");
                return "redirect:/general-data/list";
            } else {
                redirectAttributes.addFlashAttribute("error", "general data update failed");
                return "redirect:update?plants=" + general.getPlantName();
            }

    }

}
