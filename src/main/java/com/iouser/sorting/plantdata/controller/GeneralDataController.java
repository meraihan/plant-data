package com.iouser.sorting.plantdata.controller;

import com.iouser.sorting.plantdata.model.General;
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
    public String add(@ModelAttribute("general") General general, Model model) {
        return "data/gen_add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("general") General general, final RedirectAttributes redirectAttributes) {
        if (generalRepository.save(general)!=null) {
            redirectAttributes.addFlashAttribute("success", "General Data Added successful");
            return "redirect:/general-data/list";
        } else {
            redirectAttributes.addFlashAttribute("error", "General Data Add Failed");
            return "redirect:add";
        }
    }

}
