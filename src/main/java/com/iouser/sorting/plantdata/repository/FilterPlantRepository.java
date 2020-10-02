package com.iouser.sorting.plantdata.repository;

import com.iouser.sorting.plantdata.model.FilterPlant;
import com.iouser.sorting.plantdata.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilterPlantRepository extends JpaRepository<FilterPlant, Long> {
//    Optional<Plant> findByPlants(String plants);
}
