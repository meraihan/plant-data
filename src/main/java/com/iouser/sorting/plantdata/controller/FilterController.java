package com.iouser.sorting.plantdata.controller;

import com.iouser.sorting.plantdata.model.Damage;
import com.iouser.sorting.plantdata.model.FilterPlant;
import com.iouser.sorting.plantdata.model.Special;
import com.iouser.sorting.plantdata.model.User;
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
//        Optional<Plant> plant = generalRepository.findById(id);
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


        model.addAttribute("plant", generalRepository.findById(id));
        model.addAttribute("specialList", specialList);

        model.addAttribute("damageList", damageList);
        return "data/filter_view";
    }

    public static <T> List<T> toList(Optional<T> opt) {
        return opt.isPresent() ? Collections.singletonList(opt.get()) : Collections.emptyList();
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
//        for (int i=1;i<=40;i++){
//            if (filterPlant.getSlevel1() != null){
//                specialLevel += filterPlant.getSlevel1()+"|";
//            }else if (filterPlant.getSlevel2() != null){
//                specialLevel += filterPlant.getSlevel2()+"|";
//            }else if (filterPlant.getSlevel3() != null){
//                specialLevel += filterPlant.getSlevel3()+"|";
//            }else if (filterPlant.getSlevel4() != null){
//                specialLevel += filterPlant.getSlevel4()+"|";
//            }else if (filterPlant.getSlevel5() != null){
//                specialLevel += filterPlant.getSlevel5()+"|";
//            }else if (filterPlant.getSlevel6() != null){
//                specialLevel += filterPlant.getSlevel6()+"|";
//            }else if (filterPlant.getSlevel7() != null){
//                specialLevel += filterPlant.getSlevel7()+"|";
//            }else if (filterPlant.getSlevel8() != null){
//                specialLevel += filterPlant.getSlevel8()+"|";
//            }else if (filterPlant.getSlevel9() != null){
//                specialLevel += filterPlant.getSlevel9()+"|";
//            }else if (filterPlant.getSlevel10() != null){
//                specialLevel += filterPlant.getSlevel10()+"|";
//            }else if (filterPlant.getSlevel11() != null){
//                specialLevel += filterPlant.getSlevel11()+"|";
//            }else if (filterPlant.getSlevel12() != null){
//                specialLevel += filterPlant.getSlevel12()+"|";
//            }else if (filterPlant.getSlevel13() != null){
//                specialLevel += filterPlant.getSlevel13()+"|";
//            }else if (filterPlant.getSlevel14() != null){
//                specialLevel += filterPlant.getSlevel14()+"|";
//            }else if (filterPlant.getSlevel15() != null){
//                specialLevel += filterPlant.getSlevel15()+"|";
//            }else if (filterPlant.getSlevel16() != null){
//                specialLevel += filterPlant.getSlevel16()+"|";
//            }else if (filterPlant.getSlevel17() != null){
//                specialLevel += filterPlant.getSlevel17()+"|";
//            }else if (filterPlant.getSlevel18() != null){
//                specialLevel += filterPlant.getSlevel18()+"|";
//            }else if (filterPlant.getSlevel19() != null){
//                specialLevel += filterPlant.getSlevel19()+"|";
//            }else if (filterPlant.getSlevel20() != null){
//                specialLevel += filterPlant.getSlevel20()+"|";
//                //  ************** Damage Level
//            }else if (filterPlant.getDlevel1() != null){
//                damageLevel += filterPlant.getDlevel1()+"|";
//            }else if (filterPlant.getDlevel2() != null){
//                damageLevel += filterPlant.getDlevel2()+"|";
//            }else if (filterPlant.getDlevel3() != null){
//                damageLevel += filterPlant.getDlevel3()+"|";
//            }else if (filterPlant.getDlevel4() != null){
//                damageLevel += filterPlant.getDlevel4()+"|";
//            }else if (filterPlant.getDlevel5() != null){
//                damageLevel += filterPlant.getDlevel5()+"|";
//            }else if (filterPlant.getDlevel6() != null){
//                damageLevel += filterPlant.getDlevel6()+"|";
//            }else if (filterPlant.getDlevel7() != null){
//                damageLevel += filterPlant.getDlevel7()+"|";
//            }else if (filterPlant.getDlevel8() != null){
//                damageLevel += filterPlant.getDlevel8()+"|";
//            }else if (filterPlant.getDlevel9() != null){
//                damageLevel += filterPlant.getDlevel9()+"|";
//            }else if (filterPlant.getDlevel10() != null){
//                damageLevel += filterPlant.getDlevel10()+"|";
//            }else if (filterPlant.getDlevel11() != null){
//                damageLevel += filterPlant.getDlevel11()+"|";
//            }else if (filterPlant.getDlevel12() != null){
//                damageLevel += filterPlant.getDlevel12()+"|";
//            }else if (filterPlant.getDlevel13() != null){
//                damageLevel += filterPlant.getDlevel13()+"|";
//            }else if (filterPlant.getDlevel14() != null){
//                damageLevel += filterPlant.getDlevel14()+"|";
//            }else if (filterPlant.getDlevel15() != null){
//                damageLevel += filterPlant.getDlevel15()+"|";
//            }else if (filterPlant.getDlevel16() != null){
//                damageLevel += filterPlant.getDlevel16()+"|";
//            }else if (filterPlant.getDlevel17() != null){
//                damageLevel += filterPlant.getDlevel17()+"|";
//            }else if (filterPlant.getDlevel18() != null){
//                damageLevel += filterPlant.getDlevel18()+"|";
//            }else if (filterPlant.getDlevel19() != null){
//                damageLevel += filterPlant.getDlevel19()+"|";
//            }else if (filterPlant.getDlevel20() != null){
//                damageLevel += filterPlant.getDlevel20()+"|";
//            }

//        }
//        model.addAttribute("plant",filterPlantRepository.save(filterPlant));
        redirectAttributes.addFlashAttribute("success", "General Data Added successful");
        return "redirect:/general-data/list";
    }
}
