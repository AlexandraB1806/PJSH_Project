package com.example.project.repository;

import com.example.project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Student entity.
 * Provides CRUD operations and custom query methods through JpaRepository.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /**
     * Fetches the student entity by its name (String).
     * @param name student's name
     * @return the student entity
     */
    Student findByName(String name);

    /**
     * Fetches the student entity by its id (int).
     * @param id the id
     * @return the student entity
     */
    Student findById(int id);
}
