package com.mtdrfsh.jobapplicationtracker.domain;

import java.time.LocalDate;

public record CreateApplicationRequest(
    String jobTitle,
    String companyName,
    LocalDate appliedDate,
    String jobPostingUrl,
    String resumePath,
    String note
) {

}
