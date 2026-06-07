package com.github.VeinyM.neobank.repository;

import com.github.VeinyM.neobank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
