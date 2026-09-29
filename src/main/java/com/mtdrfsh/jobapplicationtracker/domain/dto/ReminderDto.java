package com.mtdrfsh.jobapplicationtracker.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.mtdrfsh.jobapplicationtracker.domain.entity.ReminderType;

public record ReminderDto(

    UUID id,
    UUID applicationId,
    ReminderType type,
    LocalDateTime dueDate,
    String message,
    boolean completed

) {

}
