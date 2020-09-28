package com.iouser.sorting.plantdata.repository;

import com.iouser.sorting.plantdata.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  GeneralRepository extends JpaRepository<Plant, Long> {
//    Optional<Plant> findByPlants(String plants);
}
