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
}
