package com.github.VeinyM.neobank.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record DepositDto(
        @NotBlank
        String name,
        @NotBlank
        BigDecimal amount
) {
}
