package com.mtdrfsh.jobapplicationtracker.domain.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public record CreateApplicationRequestDto(
    @NotBlank
    String jobTitle,
    @NotBlank
    String companyName,
    @NotBlank
    @PastOrPresent(message = ERROR_MESSAGE_APPLIED_DATE_FUTURE)
    LocalDate appliedDate,
    @Nullable
    String jobPostingUrl,
    @Nullable
    String resumePath,
    @Nullable
    @Length(max = 1000, message = ERROR_MESSAGE_NOTE_LENGTH)
    String note
) {

    private static final String ERROR_MESSAGE_NOTE_LENGTH = 
    "Note must be between 1 and 1000 characters"; 

    private static final String ERROR_MESSAGE_APPLIED_DATE_FUTURE = 
    "Applied date must be in the present"; 
}
