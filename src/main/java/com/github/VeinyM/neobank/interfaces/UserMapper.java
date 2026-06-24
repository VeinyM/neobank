package com.github.VeinyM.neobank.interfaces;

import com.github.VeinyM.neobank.dto.*;
import com.github.VeinyM.neobank.entity.Transaction;
import com.github.VeinyM.neobank.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toEntity(UserCreateDto dto);
    void updateUserFromDto(UserUpdateDto dto, @MappingTarget User entity);
    UserResponseDto toResponseDto(User user);
    List<UserResponseDto> toResponseDto(List<User> userList);

    AccountInfoDto toAccountInfoDto(User user);

    @Mapping(source = "transactionId", target = "id")
    @Mapping(source = "sender.name", target = "sender")
    @Mapping(source = "receiver.name", target = "receiver")
    TransactionDto toTransactionDto(Transaction transaction);

}
