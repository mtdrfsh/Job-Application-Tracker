package com.mtdrfsh.jobapplicationtracker.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mtdrfsh.jobapplicationtracker.controller.ApplicationNotFoundException;
import com.mtdrfsh.jobapplicationtracker.domain.CreateApplicationRequest;
import com.mtdrfsh.jobapplicationtracker.domain.CreateReminderRequest;
import com.mtdrfsh.jobapplicationtracker.domain.UpdateApplicationStatusRequest;
import com.mtdrfsh.jobapplicationtracker.domain.UpdateReminderStatusRequest;
import com.mtdrfsh.jobapplicationtracker.domain.dto.CreateApplicationRequestDto;
import com.mtdrfsh.jobapplicationtracker.domain.entity.Application;
import com.mtdrfsh.jobapplicationtracker.domain.entity.Reminder;
import com.mtdrfsh.jobapplicationtracker.repository.ApplicationRepository;
import com.mtdrfsh.jobapplicationtracker.repository.ReminderRepository;

@Service 
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final ApplicationRepository applicationRepository; 

    public ReminderService(ReminderRepository reminderRepository, ApplicationRepository applicationRepository) {
        this.reminderRepository = reminderRepository;
        this.applicationRepository = applicationRepository;
    }

    public Reminder createReminder(UUID id, CreateReminderRequest request) {

        Application application = applicationRepository.findById(id)
            .orElseThrow(() -> new ApplicationNotFoundException());

        Reminder reminder = new Reminder(
            application,
            request.type(),
            request.dueDate(),
            request.message()
        );

        return reminderRepository.save(reminder);
    }

    public List<Reminder> listReminders(UUID id) {
        return reminderRepository.findByApplicationId(id);
    }

    public Reminder getReminder(UUID reminder_id, UUID applicationId) {
        return reminderRepository.findByIdAndApplicationId(reminder_id, applicationId);
    }

    public Reminder updateReminder(UUID applicationId, UUID reminder_id, CreateReminderRequest request) {
        applicationRepository.findById(applicationId)
            .orElseThrow(() -> new ApplicationNotFoundException());

        Reminder reminder = reminderRepository.findByIdAndApplicationId(reminder_id, applicationId);
        
        reminder.setType(request.type());
        reminder.setDueDate(request.dueDate());
        reminder.setMessage(request.message());

        return reminderRepository.save(reminder);
    }

    public Reminder updateType(UUID applicationId, UUID reminder_id, UpdateReminderStatusRequest request) {
        applicationRepository.findById(applicationId)
            .orElseThrow(() -> new ApplicationNotFoundException());

        Reminder reminder = reminderRepository.findByIdAndApplicationId(reminder_id, applicationId);
        
        reminder.setType(request.type());

        return reminderRepository.save(reminder);
    }

    public Reminder isCompleted(UUID applicationId, UUID reminder_id) {
        applicationRepository.findById(applicationId)
            .orElseThrow(() -> new ApplicationNotFoundException());

        Reminder reminder = reminderRepository.findByIdAndApplicationId(reminder_id, applicationId);
        
        reminder.setCompleted(!reminder.getCompleted());

        return reminderRepository.save(reminder);
    }

    public void deleteReminder(UUID applicationId, UUID reminder_id) {
        applicationRepository.findById(applicationId)
            .orElseThrow(() -> new ApplicationNotFoundException());

        reminderRepository.findByIdAndApplicationId(reminder_id, applicationId);

        reminderRepository.deleteById(reminder_id);
    }
}
