package com.example.project.service;

import com.example.project.repository.TrainerRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of TrainerService.
 * Provides business logic for handling course-related operations.
 */
@Service
public class TrainerServiceImpl implements TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public double getSalaryByName(String name) {
        return trainerRepository.findSalaryByName(name);
    }
}
