package com.example.project.repository;

import com.example.project.entity.Trainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findByName(String name);

    double findSalaryByName(String name);
}
