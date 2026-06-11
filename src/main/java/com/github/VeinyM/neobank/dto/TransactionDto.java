package com.github.VeinyM.neobank.dto;

import jakarta.validation.constraints.Negative;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDto(
        Long id,
        String sender,
        String receiver,

        BigDecimal amount,
        LocalDateTime timestamp

) {
}
