package com.mtdrfsh.jobapplicationtracker.domain;

import com.mtdrfsh.jobapplicationtracker.domain.entity.ReminderType;

public record UpdateReminderTypeRequest(
    ReminderType type
) {

}
