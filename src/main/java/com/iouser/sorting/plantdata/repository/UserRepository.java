package com.iouser.sorting.plantdata.repository;

import com.iouser.sorting.plantdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
