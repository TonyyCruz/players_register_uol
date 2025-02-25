package com.anthony.uol_host.model;

import com.anthony.uol_host.enums.GroupCodename;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Player(
        @NotBlank(message = "Name is required.") String name,
        @NotBlank(message = "Email is required.") @Email(message = "Format invalid.") String email,
        String phone,
        String codename,
        @NotNull(message = "Please select a group.") GroupCodename groupCodename) {}
