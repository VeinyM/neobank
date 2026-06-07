package com.github.VeinyM.neobank.service;

import com.github.VeinyM.neobank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void onStart(){
        System.out.print("Starting.");
        for (int i = 0; i < 2; i++) {
            System.out.print(".");
        }
        System.out.print("\n");
    }
}
