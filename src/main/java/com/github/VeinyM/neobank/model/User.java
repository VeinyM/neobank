package com.github.VeinyM.neobank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Long userId;
    String name;
    int age;
    Long balance;
    String email;
    String phoneNumber;
    String country;
}

class Payment {
    Long paymentId;
    Long senderId;
    Long recieverId;
    Long amount;
    LocalDateTime dateTime;
}

