package com.mtdrfsh.jobapplicationtracker.domain.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.mtdrfsh.jobapplicationtracker.domain.entity.ApplicationStatus;

public record ApplicationDto(
    UUID id,
    String jobTitle,
    String companyName,
    LocalDate appliedDate,
    String jobPostingUrl,
    String resumePath,
    String note,
    ApplicationStatus status
) {

}
