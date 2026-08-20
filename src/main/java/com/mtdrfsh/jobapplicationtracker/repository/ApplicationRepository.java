package com.mtdrfsh.jobapplicationtracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtdrfsh.jobapplicationtracker.domain.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, UUID>{

}
