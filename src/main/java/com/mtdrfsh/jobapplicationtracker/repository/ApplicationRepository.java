package com.mtdrfsh.jobapplicationtracker.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtdrfsh.jobapplicationtracker.domain.entity.Application;
import com.mtdrfsh.jobapplicationtracker.domain.entity.ApplicationStatus;

public interface ApplicationRepository extends JpaRepository<Application, UUID>{

    List<Application> findByStatus(ApplicationStatus status);
    List<Application> findByJobTitleContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(String jobTitle, String companyName);

}
