package com.github.VeinyM.neobank.interfaces;

import com.github.VeinyM.neobank.dto.UserCreateDto;
import com.github.VeinyM.neobank.dto.UserResponseDto;
import com.github.VeinyM.neobank.model.User;
import com.github.VeinyM.neobank.dto.UserUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toEntity(UserCreateDto dto);
    void updateUserFromDto(UserUpdateDto dto, @MappingTarget User entity);
    UserResponseDto toResponseDto(User user);
    List<UserResponseDto> toResponseDto(List<User> userList);
}
