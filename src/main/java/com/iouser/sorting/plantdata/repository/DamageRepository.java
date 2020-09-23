package com.iouser.sorting.plantdata.repository;

import com.iouser.sorting.plantdata.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageRepository extends JpaRepository<Damage, Long> {
}
