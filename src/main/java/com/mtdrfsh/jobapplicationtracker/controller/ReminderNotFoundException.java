package com.mtdrfsh.jobapplicationtracker.controller;

public class ReminderNotFoundException extends RuntimeException {

    public ReminderNotFoundException() {
        super("Reminder Not Found");
    }
}
