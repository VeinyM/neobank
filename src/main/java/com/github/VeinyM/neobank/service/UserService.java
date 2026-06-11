package com.github.VeinyM.neobank.service;

import com.github.VeinyM.neobank.dto.*;
import com.github.VeinyM.neobank.interfaces.UserMapper;
import com.github.VeinyM.neobank.model.Transaction;
import com.github.VeinyM.neobank.model.User;
import com.github.VeinyM.neobank.repository.TransactionRepository;
import com.github.VeinyM.neobank.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, TransactionRepository transactionRepository){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.transactionRepository = transactionRepository;
    }


    public List<UserResponseDto> getAllUsers() {
        return userMapper.toResponseDto(userRepository.findAll());
    }

    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        User user = userMapper.toEntity(userCreateDto);
        user.setUserId(null);
        user.setBalance(BigDecimal.ZERO);
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

    @Transactional
    public void transfer(
            TransferDto request
    ) {
        if(request.amount().compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("Negative number detected! Are u trying to scam bozo?");
        }
        var sender = userRepository.findByName(request.senderName())
                .orElseThrow(()-> new RuntimeException("Couldn't found sender!"));

        var receiver = userRepository.findByName(request.receiverName())
                .orElseThrow(()-> new RuntimeException("Couldn't found receiver!"));

        if(sender.getName().equals(receiver.getName())){
            throw new RuntimeException("You can't send money to yourself bozo!");
        }

        if(sender.getBalance().compareTo(request.amount()) < 0){
            throw new RuntimeException("Not enough balance!");
        }

        sender.setBalance(sender.getBalance().subtract(request.amount()));
        receiver.setBalance(receiver.getBalance().add(request.amount()));

        userRepository.save(sender);
        userRepository.save(receiver);

        //TRANSACTION

        Transaction transaction = new Transaction();

        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setAmount(request.amount());
        transaction.setTimestamp(LocalDateTime.now());

        transactionRepository.save(transaction);
    }

    @Transactional
    public void deposit(
            DepositDto request
    ) {

        if(request.amount().compareTo(BigDecimal.ZERO)<=0){
            throw new RuntimeException("Why???");
        }

        var user = userRepository.findByName(request.name())
                .orElseThrow(()-> new RuntimeException("Couldn't found user to deposit!"));
        user.setBalance(user.getBalance().add(request.amount()));

        userRepository.save(user);
    }

    public AccountInfoDto getAccountInfo(
            Long id
    ) {
        var response = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Couldn't get info! (No user with such id = "+id + ")"));

        return userMapper.toAccountInfoDto(response);
    }
}
