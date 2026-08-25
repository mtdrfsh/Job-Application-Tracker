package com.mtdrfsh.jobapplicationtracker.mapper;

import org.springframework.stereotype.Component;

import com.mtdrfsh.jobapplicationtracker.domain.CreateApplicationRequest;
import com.mtdrfsh.jobapplicationtracker.domain.dto.ApplicationDto;
import com.mtdrfsh.jobapplicationtracker.domain.dto.CreateApplicationRequestDto;
import com.mtdrfsh.jobapplicationtracker.domain.entity.Application;

@Component
public class ApplicationMapper {

    public CreateApplicationRequest fromDto(CreateApplicationRequestDto dto) {
        return new CreateApplicationRequest(
        dto.jobTitle(), 
        dto.companyName(), 
        dto.appliedDate(), 
        dto.jobPostingUrl(), 
        dto.resumePath(), 
        dto.note()
    );
    }

    public ApplicationDto toDto(Application application) {
        return new ApplicationDto(
        application.getId(), 
        application.getJobTitle(), 
        application.getCompanyName(), 
        application.getAppliedDate(), 
        application.getJobPostingUrl(), 
        application.getResumePath(), 
        application.getNote(), 
        application.getStatus()
    );
    }
}
