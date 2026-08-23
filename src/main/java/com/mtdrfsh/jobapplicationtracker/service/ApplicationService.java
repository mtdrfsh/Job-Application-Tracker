package com.mtdrfsh.jobapplicationtracker.service;

import org.springframework.stereotype.Service;

import com.mtdrfsh.jobapplicationtracker.domain.CreateApplicationRequest;
import com.mtdrfsh.jobapplicationtracker.domain.entity.Application;
import com.mtdrfsh.jobapplicationtracker.repository.ApplicationRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application createApplication(CreateApplicationRequest request) {

        Application application = new Application(
            request.companyName(),
            request.jobTitle(),
            request.appliedDate(),
            request.jobPostingUrl(),
            request.resumePath(),
            request.note()
        );
        
        return applicationRepository.save(application);
    }
}
