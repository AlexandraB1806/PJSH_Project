package com.example.project.service;

/**
 * Service interface for Trainer entity.
 * Defines methods for CRUD operations and additional business logic.
 */
public interface TrainerService {
    /**
     * Fetches the salary of a specific trainer.
     * @param name trainer's name
     * @return salary (double)
     */
    double getSalaryByName(String name);
}
