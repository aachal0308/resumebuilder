package com.ashv.ats.resumebuilder.entity;

import java.util.List;
import java.util.Map;


    public class ResumeEntity {
        private String id;
        private String name;
        private List<Contact> contact;
        private List<String> languages;
        private List<Experience> experience;
        private List<Education> education;
        private List<String> hobbies;
        private List<Skill> skills;
        private ExtraData extraData;

        // Constructors
        public void Resume() {}

        public void Resume(String id, String name, List<Contact> contact, List<String> languages, List<Experience> experience,
                           List<Education> education, List<String> hobbies, List<Skill> skills,ExtraData extraData) {
            this.id = id;
            this.name = name;
            this.contact = contact;
            this.languages = languages;
            this.experience = experience;
            this.education = education;
            this.hobbies = hobbies;
            this.skills = skills;
            this.extraData = extraData;
        }

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public List<Contact> getContact() { return contact; }
        public void setContact(List<Contact> contact) { this.contact = contact; }

        public List<String> getLanguages() { return languages; }
        public void setLanguages(List<String> languages) { this.languages = languages; }

        public List<Experience> getExperience() { return experience; }
        public void setExperience(List<Experience> experience) { this.experience = experience; }

        public List<Education> getEducation() { return education; }
        public void setEducation(List<Education> education) { this.education = education; }

        public List<String> getHobbies() { return hobbies; }
        public void setHobbies(List<String> hobbies) { this.hobbies = hobbies; }

        public List<Skill> getSkills() { return skills; }
        public void setSkills(List<Skill> skills) { this.skills = skills; }

        public ExtraData getExtraData() { return extraData; }
        public void setExtraData(ExtraData extraData) { this.extraData = extraData; }
    }

    class Contact {
        private String key;
        private String value;

        public Contact() {}
        public Contact(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() { return key; }
        public void setKey(String key) { this.key = key; }

        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
    }

    class Experience {
        private String company;
        private List<ExperienceDetail> details;

        public Experience() {}
        public Experience(String company, List<ExperienceDetail> details) {
            this.company = company;
            this.details = details;
        }

        public String getCompany() { return company; }
        public void setCompany(String company) { this.company = company; }

        public List<ExperienceDetail> getDetails() { return details; }
        public void setDetails(List<ExperienceDetail> details) { this.details = details; }
    }

    class ExperienceDetail {
        private String designation;
        private String project;
        private DateRange from;
        private DateRange to;
        private String summary;

        public ExperienceDetail() {}
        public ExperienceDetail(String designation, String project, DateRange from, DateRange to, String summary) {
            this.designation = designation;
            this.project = project;
            this.from = from;
            this.to = to;
            this.summary = summary;
        }

        public String getDesignation() { return designation; }
        public void setDesignation(String designation) { this.designation = designation; }

        public String getProject() { return project; }
        public void setProject(String project) { this.project = project; }

        public DateRange getFrom() { return from; }
        public void setFrom(DateRange from) { this.from = from; }

        public DateRange getTo() { return to; }
        public void setTo(DateRange to) { this.to = to; }

        public String getSummary() { return summary; }
        public void setSummary(String summary) { this.summary = summary; }
    }

    class Education {
        private String institute;
        private String university;
        private String averageGrade;
        private DateRange from;
        private DateRange to;
        private List<EducationDetail> details;

        public Education() {}
        public Education(String institute, String university, String averageGrade, DateRange from, DateRange to, List<EducationDetail> details) {
            this.institute = institute;
            this.university = university;
            this.averageGrade = averageGrade;
            this.from = from;
            this.to = to;
            this.details = details;
        }

        public String getInstitute() { return institute; }
        public void setInstitute(String institute) { this.institute = institute; }

        public String getUniversity() { return university; }
        public void setUniversity(String university) { this.university = university; }

        public String getAverageGrade() { return averageGrade; }
        public void setAverageGrade(String averageGrade) { this.averageGrade = averageGrade; }

        public DateRange getFrom() { return from; }
        public void setFrom(DateRange from) { this.from = from; }

        public DateRange getTo() { return to; }
        public void setTo(DateRange to) { this.to = to; }

        public List<EducationDetail> getDetails() { return details; }
        public void setDetails(List<EducationDetail> details) { this.details = details; }
    }

    class EducationDetail {
        private String subtitle;
        private DateRange from;
        private DateRange to;
        private String grade;

        public EducationDetail() {}
        public EducationDetail(String subtitle, DateRange from, DateRange to, String grade) {
            this.subtitle = subtitle;
            this.from = from;
            this.to = to;
            this.grade = grade;
        }

        public String getSubtitle() { return subtitle; }
        public void setSubtitle(String subtitle) { this.subtitle = subtitle; }

        public DateRange getFrom() { return from; }
        public void setFrom(DateRange from) { this.from = from; }

        public DateRange getTo() { return to; }
        public void setTo(DateRange to) { this.to = to; }

        public String getGrade() { return grade; }
        public void setGrade(String grade) { this.grade = grade; }
    }
class Skill {
    private String name;
    private String proficiency;

    public Skill() {}
    public Skill(String name, String proficiency) {
        this.name = name;
        this.proficiency = proficiency;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getProficiency() { return proficiency; }
    public void setProficiency(String proficiency) { this.proficiency = proficiency; }
}

    class DateRange {
        private int day;
        private int month;
        private int year;

        public DateRange() {}
        public DateRange(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    class ExtraData {
        private Map<String, Object> extra;
    }
