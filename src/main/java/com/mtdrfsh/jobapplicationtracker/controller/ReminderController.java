package com.mtdrfsh.jobapplicationtracker.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtdrfsh.jobapplicationtracker.domain.CreateReminderRequest;
import com.mtdrfsh.jobapplicationtracker.domain.UpdateApplicationStatusRequest;
import com.mtdrfsh.jobapplicationtracker.domain.UpdateReminderStatusRequest;
import com.mtdrfsh.jobapplicationtracker.domain.dto.ApplicationDto;
import com.mtdrfsh.jobapplicationtracker.domain.dto.CreateReminderRequestDto;
import com.mtdrfsh.jobapplicationtracker.domain.dto.ReminderDto;
import com.mtdrfsh.jobapplicationtracker.domain.entity.Application;
import com.mtdrfsh.jobapplicationtracker.domain.entity.Reminder;
import com.mtdrfsh.jobapplicationtracker.mapper.ReminderMapper;
import com.mtdrfsh.jobapplicationtracker.service.ReminderService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping(path = "/api/v1/applications/{id}/reminders")
public class ReminderController {

    private final ReminderService reminderService;
    private final ReminderMapper reminderMapper;

    public ReminderController(ReminderService reminderService, ReminderMapper reminderMapper) {
        this.reminderService = reminderService;
        this.reminderMapper = reminderMapper;
    }

    @PostMapping
    public ResponseEntity<ReminderDto> createReminder(
        @PathVariable UUID id,
        @Valid @RequestBody CreateReminderRequestDto createReminderRequestDto
    ) {
        CreateReminderRequest createReminderRequest = reminderMapper.fromDto(createReminderRequestDto);
        Reminder reminder = reminderService.createReminder(id,createReminderRequest);
        ReminderDto reminderDto = reminderMapper.toDto(reminder); 
        return new ResponseEntity<>(reminderDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReminderDto>> listReminders(
        @PathVariable UUID id
    ) {
        List<Reminder> reminders = reminderService.listReminders(id);
        List<ReminderDto> reminderDto = reminders.stream().map(reminderMapper::toDto).toList();
        return ResponseEntity.ok(reminderDto);
    }

    @GetMapping("/{reminder_id}")
    public ResponseEntity<ReminderDto> getReminder(
        @PathVariable UUID id,
        @PathVariable UUID reminder_id
    ) {
        Reminder reminder = reminderService.getReminder(id, reminder_id);
        ReminderDto reminderDto = reminderMapper.toDto(reminder);
        return ResponseEntity.ok(reminderDto);
    }

    @PutMapping("/{reminder_id}")
    public ResponseEntity<ReminderDto> updateReminder(
        @PathVariable UUID id,
        @PathVariable UUID reminder_id,
        @Valid @RequestBody CreateReminderRequestDto createReminderRequestDto
    ) {
        CreateReminderRequest createReminderRequest = reminderMapper.fromDto(createReminderRequestDto);
        Reminder reminder = reminderService.updateReminder(id,reminder_id,createReminderRequest);
        ReminderDto reminderDto = reminderMapper.toDto(reminder);
        return ResponseEntity.ok(reminderDto);
    }

    @PatchMapping("/{reminder_id}/status")
    public ResponseEntity<ReminderDto> updateType(
        @PathVariable UUID id,
        @PathVariable UUID reminder_id,
        @Valid @RequestBody UpdateReminderStatusRequest updateReminderStatusRequest
    ) {
        Reminder reminder = reminderService.updateType(id, reminder_id, updateReminderStatusRequest);
        ReminderDto reminderDto = reminderMapper.toDto(reminder);
        return ResponseEntity.ok(reminderDto);
    }

    @PatchMapping("/{reminder_id}")
    public ResponseEntity<ReminderDto> isCompleted(
        @PathVariable UUID id,
        @PathVariable UUID reminder_id
    ) {
        Reminder reminder = reminderService.isCompleted(id, reminder_id);
        ReminderDto reminderDto = reminderMapper.toDto(reminder);
        return ResponseEntity.ok(reminderDto);
    }

    @DeleteMapping("/{reminder_id}")
    public ResponseEntity<Void> deleteReminder(
        @PathVariable UUID id,
        @PathVariable UUID reminder_id
    ) {
        reminderService.deleteReminder(id, reminder_id);
        return ResponseEntity.noContent().build();
    }
}
