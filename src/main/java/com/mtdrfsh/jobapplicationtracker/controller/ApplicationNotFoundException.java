package com.mtdrfsh.jobapplicationtracker.controller;

public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException() {
        super("Application not found");
    }
}
