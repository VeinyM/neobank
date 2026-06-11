package com.github.VeinyM.neobank.service;

import com.github.VeinyM.neobank.dto.UserCreateDto;
import com.github.VeinyM.neobank.dto.UserResponseDto;
import com.github.VeinyM.neobank.interfaces.UserMapper;
import com.github.VeinyM.neobank.model.User;
import com.github.VeinyM.neobank.dto.UserUpdateDto;
import com.github.VeinyM.neobank.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public List<UserResponseDto> getAllUsers() {
        return userMapper.toResponseDto(userRepository.findAll());
    }

    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        User user = userMapper.toEntity(userCreateDto);
        user.setUserId(null);
        user.setBalance(0L);
        User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    public UserResponseDto getUser(Long id) {
        return userMapper.toResponseDto(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Couldn't found user with id = " + id)));

    }

    public UserResponseDto updateUser(UserUpdateDto dto, Long id) {
        return userRepository.findById(id)
                .map(currentUser -> {
                    userMapper.updateUserFromDto(dto, currentUser);
                    User savedUser = userRepository.save(currentUser);
                    return userMapper.toResponseDto(savedUser);
                })
                .orElseThrow(() -> new EntityNotFoundException("Couldn't found user with id = " + id));

    }

    public void deleteUser(
            Long id
    ){
        if(!userRepository.existsById(id)){
            throw new EntityNotFoundException("Couldn't found user with id = " + id);
        }
        userRepository.deleteById(id);
    }
}
