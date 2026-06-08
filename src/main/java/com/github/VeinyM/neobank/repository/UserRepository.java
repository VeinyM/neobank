package com.github.VeinyM.neobank.repository;

import com.github.VeinyM.neobank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //done
}
