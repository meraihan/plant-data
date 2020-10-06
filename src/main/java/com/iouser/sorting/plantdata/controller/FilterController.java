package com.iouser.sorting.plantdata.controller;

import com.iouser.sorting.plantdata.model.*;
import com.iouser.sorting.plantdata.repository.DamageRepository;
import com.iouser.sorting.plantdata.repository.FilterPlantRepository;
import com.iouser.sorting.plantdata.repository.GeneralRepository;
import com.iouser.sorting.plantdata.repository.SpecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Field;
import java.util.*;


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

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("plantList", generalRepository.findAll());
        return "data/filter_view";
    }

    @GetMapping("/filter_view")
    public String filterView(@RequestParam("id") Long id, Model model) {
        FilterPlant filterPlant = new FilterPlant();
        Optional<Plant> plantOptional = generalRepository.findById(id);
        filterPlant.setPlant(plantOptional.get());

        Optional<Special> specialOptional = specialRepository.findById(id);
        List<Special> specialList = new ArrayList<>();
        Special sp = new Special();
        sp.setLevel(specialOptional.get().getLevel1());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel2());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel3());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel4());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel5());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel6());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel7());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel8());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel9());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel10());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel11());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel12());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel13());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel14());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel15());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel16());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel17());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel18());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel19());
        specialList.add(sp);

        sp = new Special();
        sp.setLevel(specialOptional.get().getLevel20());
        specialList.add(sp);

// Damage
        Optional<Damage> damageOptiona = damageRepository.findById(id);
        List<Damage> damageList = new ArrayList<>();
        Damage dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel1());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel2());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel3());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel4());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel5());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel6());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel7());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel8());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel9());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel10());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel11());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel12());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel13());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel14());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel15());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel16());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel17());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel18());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel19());
        damageList.add(dmg);

        dmg = new Damage();
        dmg.setLevel(damageOptiona.get().getLevel20());
        damageList.add(dmg);

        filterPlant.setSlevelList(specialList);
        filterPlant.setDamageList(damageList);
        model.addAttribute("filterPlant", filterPlant);
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
