package com.mtdrfsh.jobapplicationtracker.domain;

import com.mtdrfsh.jobapplicationtracker.domain.entity.ApplicationStatus;

public record UpdateApplicationStatusRequest (
    ApplicationStatus status
){
    
}
