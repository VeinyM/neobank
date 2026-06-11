package com.github.VeinyM.neobank.controller;

import com.github.VeinyM.neobank.dto.UserCreateDto;
import com.github.VeinyM.neobank.dto.UserResponseDto;
import com.github.VeinyM.neobank.model.User;
import com.github.VeinyM.neobank.dto.UserUpdateDto;
import com.github.VeinyM.neobank.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        List<UserResponseDto> userResponseDtoList = userService.getAllUsers();
        log.info("Method getAllUsers used");
        return ResponseEntity.ok(userResponseDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(
            @PathVariable Long id
    ){
        UserResponseDto userResponseDto = userService.getUser(id);
        log.info("Method getUser used");
        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @Valid @RequestBody UserCreateDto userCreateDto
            ){
        UserResponseDto userResponseDto = userService.createUser(userCreateDto);
        log.info("Method createUser used");
        return ResponseEntity.ok(userResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @Valid @RequestBody UserUpdateDto userUpdateDto,
            @PathVariable Long id
    ){
        UserResponseDto updatedUserResponseDto = userService.updateUser(userUpdateDto,id);
        log.info("Method updateUser used");
        return ResponseEntity.ok(updatedUserResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id
    ){
        userService.deleteUser(id);
        log.info("Method deleteUser used");
        return ResponseEntity.noContent().build();
    }
}
