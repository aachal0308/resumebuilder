package com.ashv.ats.resumebuilder.Dto;
public class ResumeDTO {
    private String name;
    private String email;
    private String experience;

    // Constructors
    public ResumeDTO() {}

    public ResumeDTO(String name, String email, String experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }
}
