package com.example.readfile.Entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

public class Audit {

    @CreationTimestamp
    public Timestamp createdAt;
    @CreationTimestamp
    public String createdBy;
    @CreationTimestamp
    public Timestamp updatedAt;
    @CreationTimestamp
    public String updatedBy;

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
