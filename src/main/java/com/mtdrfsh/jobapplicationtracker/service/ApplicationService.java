package com.mtdrfsh.jobapplicationtracker.service;

import java.util.List;

import org.springframework.data.domain.Sort;
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
            request.jobTitle(),
            request.companyName(),
            request.appliedDate(),
            request.jobPostingUrl(),
            request.resumePath(),
            request.note()
        );
        
        return applicationRepository.save(application);
    }

    public List<Application> listApplications() {
        return applicationRepository.findAll(Sort.by(Sort.Direction.ASC, "appliedDate"));
    }
}
