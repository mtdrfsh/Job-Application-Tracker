package com.mtdrfsh.jobapplicationtracker.service;

import java.util.List;
import java.util.UUID;

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

    public Application updateApplication(UUID id, CreateApplicationRequest request) {
        Application application = applicationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));
        
        application.setJobTitle(request.jobTitle());
        application.setCompanyName(request.companyName());
        application.setAppliedDate(request.appliedDate());
        application.setJobPostingUrl(request.jobPostingUrl());
        application.setResumePath(request.resumePath());
        application.setNote(request.note());

        return applicationRepository.save(application);
    }

    public void deleteApplication(UUID id) {
        applicationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));

        applicationRepository.deleteById(id);
    }
}
