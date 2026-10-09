package com.mtdrfsh.jobapplicationtracker.controller;

public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException() {
        super("HTTP 404 Not Found");
    }
}
