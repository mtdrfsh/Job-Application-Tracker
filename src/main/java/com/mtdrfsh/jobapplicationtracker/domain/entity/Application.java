package com.mtdrfsh.jobapplicationtracker.domain.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "applied_date", nullable = false)
    private LocalDate appliedDate;

    @Column(name = "job_posting_url")
    private String jobPostingUrl;

    @Column(name = "resume_path")
    private String resumePath;

    @Column(name = "note", length = 1000)
    private String note;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ApplicationStatus status;

    public Application() {
    }

    public Application(String jobTitle, String companyName, LocalDate appliedDate, String jobPostingUrl,
            String resumePath, String note) {
                
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.appliedDate = appliedDate;
        this.jobPostingUrl = jobPostingUrl;
        this.resumePath = resumePath;
        this.note = note;
        this.status = ApplicationStatus.APPLIED;
    }

    public UUID getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getJobPostingUrl() {
        return jobPostingUrl;
    }

    public void setJobPostingUrl(String jobPostingUrl) {
        this.jobPostingUrl = jobPostingUrl;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application [id=" + id + 
        ", jobTitle=" + jobTitle + 
        ", companyName=" + companyName + 
        ", appliedDate=" + appliedDate + 
        ", jobPostingUrl=" + jobPostingUrl + 
        ", resumePath=" + resumePath + 
        ", note=" + note + 
        ", status=" + status +
        "]";
    }

    
}
