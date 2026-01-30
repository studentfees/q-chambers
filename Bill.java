package com.qchambers.model;

import java.time.LocalDate;

public class Bill {
    private String id;
    private String caseId;
    private double amount;
    private String description;
    private LocalDate date;
    private boolean paid;

    public Bill(String id, String caseId, double amount, String description, LocalDate date, boolean paid) {
        this.id = id;
        this.caseId = caseId;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.paid = paid;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCaseId() { return caseId; }
    public void setCaseId(String caseId) { this.caseId = caseId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }

    @Override
    public String toString() {
        return description + " - $" + amount;
    }
}
