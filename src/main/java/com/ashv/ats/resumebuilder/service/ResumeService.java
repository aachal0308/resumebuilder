package com.ashv.ats.resumebuilder.service;

import com.ashv.ats.resumebuilder.Dto.ResumeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    // Save user data (Only Raw Data, No HTML)
    public String saveResume(ResumeDTO resumeDTO) {
        Resume resume = new Resume(null, resumeDTO.getName(), resumeDTO.getEmail(), resumeDTO.getExperience());
        Resume savedResume = resumeRepository.save(resume);
        return savedResume.getId();
    }

    // Generate HTML on Demand
    public String generateResumeHtml(String id) {
        Optional<Resume> resumeOpt = resumeRepository.findById(id);
        if (resumeOpt.isEmpty()) {
            return "Resume not found";
        }

        Resume resume = resumeOpt.get();

        // Generate HTML dynamically
        return "<html><body>" +
                "<h1>" + resume.getName() + "</h1>" +
                "<p>Email: " + resume.getEmail() + "</p>" +
                "<p>Experience: " + resume.getExperience() + "</p>" +
                "</body></html>";
    }
}
