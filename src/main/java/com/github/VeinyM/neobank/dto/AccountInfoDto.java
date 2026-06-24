package com.github.VeinyM.neobank.dto;

import java.math.BigDecimal;
import java.util.List;

public record AccountInfoDto( //Лень дописовать аннотации! В релизе сделаю!!!
        String name,
        Integer age,
        BigDecimal balance,
        String email,
        String phoneNumber,
        String country,
        List<TransactionDto> sendTransactions,
        List<TransactionDto> receivedTransactions
) {
}
