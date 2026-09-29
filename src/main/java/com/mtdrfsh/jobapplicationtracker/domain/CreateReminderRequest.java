package com.mtdrfsh.jobapplicationtracker.domain;

import java.time.LocalDateTime;

import com.mtdrfsh.jobapplicationtracker.domain.entity.ReminderType;

public record CreateReminderRequest(

    ReminderType type,
    LocalDateTime dueDate,
    String message

) {

}
