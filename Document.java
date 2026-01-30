package com.qchambers.model;

import java.time.LocalDate;

public class Document {
    private String id;
    private String name;
    private String type;
    private String caseId;
    private LocalDate uploadDate;
    private String filePath;

    public Document(String id, String name, String type, String caseId, LocalDate uploadDate, String filePath) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.caseId = caseId;
        this.uploadDate = uploadDate;
        this.filePath = filePath;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getCaseId() { return caseId; }
    public void setCaseId(String caseId) { this.caseId = caseId; }

    public LocalDate getUploadDate() { return uploadDate; }
    public void setUploadDate(LocalDate uploadDate) { this.uploadDate = uploadDate; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    @Override
    public String toString() {
        return name;
    }
}
