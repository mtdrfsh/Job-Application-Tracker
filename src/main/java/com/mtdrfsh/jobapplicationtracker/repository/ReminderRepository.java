package com.mtdrfsh.jobapplicationtracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtdrfsh.jobapplicationtracker.domain.entity.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder, UUID>{

}
