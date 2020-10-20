package com.iouser.sorting.plantdata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iouser.sorting.plantdata.model.*;
import com.iouser.sorting.plantdata.repository.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/filter-data-ajax")
public class FilterControllerAjax {

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


    @GetMapping(value = "/plant_info/{id}", produces = {"application/json"})
    public String list(@PathVariable() Long id) throws JsonProcessingException {
        Plant plant = filterPlantRepositoryWithJdbc.findById(id);
        FilterPlant filterPlant = new FilterPlant();
        filterPlant.setPlant(plant);
        //   Special
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

        filterPlant.setSpecialList(specialList);
        filterPlant.setDamageList(damageList);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(filterPlant);
        return json;
    }

    @GetMapping(value = "/plant_id_list", produces = {"application/json"})
    public String list() throws JsonProcessingException {
        List<Long> plantIdList = filterPlantRepositoryWithJdbc.findAllPlantId();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(plantIdList);
        return json;
    }


    @PostMapping(value = "/save-filter-config", produces = {"application/json"})
    public String saveFilterConfig(@RequestBody String selectedPlantData) throws JSONException {
        Integer plantId = 0;
        String slevel = null;
        String dlevel = null;
        JSONArray jsonArray = new JSONArray(selectedPlantData);
        for (int i = 0; i < jsonArray.length(); i++) {
            if (!jsonArray.get(i).equals(null)) {
                plantId = (Integer) ((JSONArray) ((JSONArray) jsonArray.get(i)).get(0)).get(0);
                slevel = parseLevel(((JSONArray) ((JSONArray) jsonArray.get(i)).get(1)));
                dlevel = parseLevel(((JSONArray) ((JSONArray) jsonArray.get(i)).get(2)));
            }
        }
        System.out.println(plantId);
        System.out.println(slevel);
        System.out.println(dlevel);
        return null;
    }

    private String parseLevel(JSONArray jsonArray) throws JSONException {
        StringBuilder sb = new StringBuilder();
        String levelId =null;
        for (int i = 0; i < jsonArray.length(); i++) {
            if (!jsonArray.get(i).equals(null)) {
                levelId = (String) jsonArray.get(i);
                sb.append(levelId).append("|");
            }
        }
        return sb.toString();
    }
}
