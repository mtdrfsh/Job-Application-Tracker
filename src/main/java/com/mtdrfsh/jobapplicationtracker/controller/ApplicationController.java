package com.mtdrfsh.jobapplicationtracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtdrfsh.jobapplicationtracker.domain.CreateApplicationRequest;
import com.mtdrfsh.jobapplicationtracker.domain.dto.ApplicationDto;
import com.mtdrfsh.jobapplicationtracker.domain.dto.CreateApplicationRequestDto;
import com.mtdrfsh.jobapplicationtracker.domain.entity.Application;
import com.mtdrfsh.jobapplicationtracker.mapper.ApplicationMapper;
import com.mtdrfsh.jobapplicationtracker.service.ApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationMapper applicationMapper;

    public ApplicationController(ApplicationService applicationService, ApplicationMapper applicationMapper) {
        this.applicationService = applicationService;
        this.applicationMapper = applicationMapper;
    }

    @PostMapping
    public ResponseEntity<ApplicationDto> createApplication(
        @Valid @RequestBody CreateApplicationRequestDto createApplicationRequestDto
    ) {
        CreateApplicationRequest createApplicationRequest = applicationMapper.fromDto(createApplicationRequestDto);
        Application application = applicationService.createApplication(createApplicationRequest);
        ApplicationDto creApplicationDto = applicationMapper.toDto(application);
        return new ResponseEntity<>(creApplicationDto, HttpStatus.CREATED);
    }
    
}
