package com.github.VeinyM.neobank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;

public record TransferDto(
        @NotBlank(message = "Blank sender Name")
        String senderName,
        @NotBlank(message = "Blank receiver Name")
        String receiverName,
        @NotNull
        BigDecimal amount
) {
}
