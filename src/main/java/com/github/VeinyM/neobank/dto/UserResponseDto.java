package com.github.VeinyM.neobank.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record UserResponseDto(
        @NotBlank(message = "This row mustn't be empty!")
        String name,
        @Min(value = 18, message = "Who's our little sweet boy??? Get out of here!")
        @Max(value = 99, message = "Who invited here a living corpse??? Get out of here!")
        Integer age,
        @NotBlank(message = "This row mustn't be empty!")
        @Email(message = "Wrong!!!")
        String email,
        @NotBlank(message = "Ask your mother for your number!!!")
        String phoneNumber,
        @NotBlank(message = "If u can't remember where u live, u must be in Garbage Country, didn't ya?")
        @Size(min = 2, max = 3, message = "2 or 3 letter u know?! (f.e. uz,kz,ru,in)")
        String country
) {
}
