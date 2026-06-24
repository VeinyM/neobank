package com.github.VeinyM.neobank.repository;

import com.github.VeinyM.neobank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

//    @Query("Select u From User u Where u.name = :name")
    Optional<User> findByName(String name);

//    @Query("Select u From User u Where u.username = :username")
    Optional<User> findByUsername(String username);
}
