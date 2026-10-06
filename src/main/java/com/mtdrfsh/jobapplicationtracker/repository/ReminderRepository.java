package com.mtdrfsh.jobapplicationtracker.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtdrfsh.jobapplicationtracker.domain.entity.Application;
import com.mtdrfsh.jobapplicationtracker.domain.entity.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder, UUID>{

    List<Reminder> findByApplicationId(UUID id);
    Reminder findByIdAndApplicationId(UUID id, UUID application_id);
}
