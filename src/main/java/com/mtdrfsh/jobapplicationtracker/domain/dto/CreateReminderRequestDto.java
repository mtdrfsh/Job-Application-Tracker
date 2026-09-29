package com.mtdrfsh.jobapplicationtracker.domain.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import com.mtdrfsh.jobapplicationtracker.domain.entity.ReminderType;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record CreateReminderRequestDto(

    @NotNull 
    ReminderType type,
    @Future
    LocalDateTime dueDate,
    @NotNull 
    @Length(max = 1000, message = "ERROR_MESSAGE_NOTE_LENGTH")
    String message

) {
    
}
