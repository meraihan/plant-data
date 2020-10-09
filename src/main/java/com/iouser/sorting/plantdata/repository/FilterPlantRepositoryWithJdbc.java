package com.iouser.sorting.plantdata.repository;


import com.iouser.sorting.plantdata.model.Plant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class FilterPlantRepositoryWithJdbc{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Plant findById(Long id) {
        String query = "SELECT *  FROM plant WHERE ID = ?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[] {id}, (rs, rowNum) -> {
                Plant plant = new Plant();
                plant.setId(rs.getLong("id"));
                plant.setPlantName(rs.getString("plant_name"));
                plant.setFamily(rs.getString("family"));
                plant.setUsage(rs.getString("usage"));
                plant.setActivationRange(rs.getString("activation_range"));
                plant.setAttackDirection(rs.getString("attack_direction"));
                plant.setShotStyle(rs.getString("shot_style"));
                plant.setAcquisition(rs.getString("acquisition"));
                return plant;
            });
        } catch (DataAccessException de) {
            de.printStackTrace();
            log.error("Plant Info not found for {} ", id);
            return null;
        }
    }

    public List<Long> findAllPlantId() {
        String query = "SELECT *  FROM plant";
        try {
            return jdbcTemplate.query(query,  (rs, rowNum) -> {
               return rs.getLong("id");
            });
        } catch (DataAccessException de) {
            de.printStackTrace();
            log.error("Plant List found ");
            return null;
        }
    }
}
