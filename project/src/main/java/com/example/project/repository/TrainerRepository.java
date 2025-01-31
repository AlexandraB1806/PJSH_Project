package com.example.project.repository;

import com.example.project.entity.Trainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Trainer entity.
 * Provides CRUD operations and custom query methods through JpaRepository.
 */
@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    /**
     * Fetches the trainer entity by its name (String).
     * @param name trainer's name
     * @return the trainer entity
     */
    Trainer findByName(String name);

    /**
     * Fetches the salary for a specific trainer (provide the name).
     * @param name the trainer's name
     * @return the salary (double)
     */
    double findSalaryByName(String name);
}
