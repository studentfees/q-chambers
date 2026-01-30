package com.qchambers.model;

import java.time.LocalDate;
import java.util.List;

public class Case {
    private String id;
    private String title;
    private String clientId;
    private String status;
    private LocalDate openDate;
    private LocalDate closeDate;
    private String description;
    private List<String> documentIds;

    public Case(String id, String title, String clientId, String status, LocalDate openDate, LocalDate closeDate, String description, List<String> documentIds) {
        this.id = id;
        this.title = title;
        this.clientId = clientId;
        this.status = status;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.description = description;
        this.documentIds = documentIds;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getOpenDate() { return openDate; }
    public void setOpenDate(LocalDate openDate) { this.openDate = openDate; }

    public LocalDate getCloseDate() { return closeDate; }
    public void setCloseDate(LocalDate closeDate) { this.closeDate = closeDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getDocumentIds() { return documentIds; }
    public void setDocumentIds(List<String> documentIds) { this.documentIds = documentIds; }

    @Override
    public String toString() {
        return title;
    }
}
