package com.mtdrfsh.jobapplicationtracker.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reminders")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "application_id", updatable = false, nullable = false)
    private Application application;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ReminderType type;

    @Column(name = "due_date")
    private LocalDateTime dueDate;
    
    @Column(name = "message", nullable = false, length = 100)
    private String message;

    @Column(name = "completed", nullable = false)
    private boolean completed = false;

    public Reminder() {
    }

    public Reminder(Application application, ReminderType type, LocalDateTime dueDate, String message) {
        this.application = application;
        this.type = type;
        this.dueDate = dueDate;
        this.message = message;
        this.completed = false;
    }

    public UUID getId() {
        return id;
    }

    public Application getApplication() {
        return application;
    }

    public ReminderType getType() {
        return type;
    }

    public void setType(ReminderType type) {
        this.type = type;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
