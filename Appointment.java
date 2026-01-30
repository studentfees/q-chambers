package com.qchambers.model;

import java.time.LocalDateTime;

public class Appointment {
    private String id;
    private String title;
    private String clientId;
    private String caseId;
    private LocalDateTime dateTime;
    private String location;
    private String notes;

    public Appointment(String id, String title, String clientId, String caseId, LocalDateTime dateTime, String location, String notes) {
        this.id = id;
        this.title = title;
        this.clientId = clientId;
        this.caseId = caseId;
        this.dateTime = dateTime;
        this.location = location;
        this.notes = notes;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }

    public String getCaseId() { return caseId; }
    public void setCaseId(String caseId) { this.caseId = caseId; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return title + " - " + dateTime.toString();
    }
}
