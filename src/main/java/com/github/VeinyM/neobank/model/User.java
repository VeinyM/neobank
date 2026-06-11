package com.github.VeinyM.neobank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;
    @Column
    String name;

    @Column
    Integer age;

    @Column
    Long balance;

    @Column
    String email;

    @Column
    String phoneNumber;

    @Column
    String country;
}

//class Payment {
//    Long paymentId;
//    Long senderId;
//    Long recieverId;
//    Long amount;
//    LocalDateTime dateTime;
//}

