package com.ashv.ats.resumebuilder.entity;
@Document(collection = "resumes")

public class ResumeEntity {
    // MongoDB Collection Name
        @Id
        private String id;  // MongoDB ID (String)

        private String name;
        private String email;
        private String experience;

        // 🔹 Constructors
        public void Resume() {}

        public void Resume(String id, String name, String email, String experience) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.experience = experience;
        }

        // 🔹 Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getExperience() { return experience; }
        public void setExperience(String experience) { this.experience = experience; }
    }
