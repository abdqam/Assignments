package com.mvc.languages.languages.models;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @Size(min = 3, max = 20)
    private String creator;
    @NotNull
    private Double currentVersion;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;


    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public Language() {
    }

    public Language(@Size(min = 3, max = 20) String name, @Size(min = 3, max = 20) String creator, Double currentVersion) {
        this.name = name;
        this.creator = creator;
        this.currentVersion = currentVersion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Double getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(Double currentVersion) {
        this.currentVersion = currentVersion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}