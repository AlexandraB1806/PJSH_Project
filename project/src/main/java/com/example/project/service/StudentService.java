package com.example.project.service;

import com.example.project.entity.Student;
import com.example.project.enums.CourseName;
import com.example.project.enums.Day;

/**
 * Service interface for Student entity.
 * Defines methods for CRUD operations and additional business logic.
 */
public interface StudentService {
    /**
     * Searches for the subscription of a specific student and checks if there
     * are enough available sessions to perform. If so, update the courses
     * a student attends and the number of performed sessions.
     * @param studentName studentName
     * @param courseName courseName
     * @param day day
     * @return the updated number of performed sessions
     * @throws Throwable no more available sessions
     */
    int attendCourse(String studentName, CourseName courseName, Day day) throws Throwable;

    /**
     * Fetches a student with the specific id.
     * @param id id
     * @return the student entity
     */
    Student getStudentById(int id);
}
