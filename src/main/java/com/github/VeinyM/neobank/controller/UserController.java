package com.github.VeinyM.neobank.controller;

import com.github.VeinyM.neobank.dto.*;
import com.github.VeinyM.neobank.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/new")
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
    /////////////////////////////////////////////////////////
    @PostMapping("/transfer")
    public ResponseEntity<Void> transfer(
            @RequestBody TransferDto request
    ){
        userService.transfer(request);
        log.info("Money successfully sent!");
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> deposit(
            @RequestBody DepositDto request
    ){
        userService.deposit(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/info")
    public ResponseEntity<AccountInfoDto> getAccountInfo(
            @PathVariable("id") Long id
    ){
        AccountInfoDto acc = userService.getAccountInfo(id);
        return ResponseEntity.ok(acc);
    }
}
