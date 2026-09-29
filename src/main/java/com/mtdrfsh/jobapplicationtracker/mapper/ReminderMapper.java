package com.mtdrfsh.jobapplicationtracker.mapper;

import org.springframework.stereotype.Component;

import com.mtdrfsh.jobapplicationtracker.domain.CreateReminderRequest;
import com.mtdrfsh.jobapplicationtracker.domain.dto.CreateReminderRequestDto;
import com.mtdrfsh.jobapplicationtracker.domain.dto.ReminderDto;
import com.mtdrfsh.jobapplicationtracker.domain.entity.Reminder;

@Component
public class ReminderMapper {

    public CreateReminderRequest fromDto(CreateReminderRequestDto dto) {
        return new CreateReminderRequest(
            dto.type(),
            dto.dueDate(),
            dto.message()
        );
    }

    public ReminderDto toDto(Reminder reminder) {
        return new ReminderDto(
            reminder.getId(),
            reminder.getApplication().getId(),
            reminder.getType(),
            reminder.getDueDate(),
            reminder.getMessage(),
            reminder.getCompleted()
        );
    }
}
