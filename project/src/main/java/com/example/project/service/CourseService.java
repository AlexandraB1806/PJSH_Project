package com.example.project.service;

import com.example.project.entity.Course;
import com.example.project.enums.CourseName;
import com.example.project.enums.Day;
import com.example.project.enums.Studio;

import java.time.LocalTime;
import java.util.List;

/**
 * Service interface for Course entity.
 * Defines methods for CRUD operations and additional business logic.
 */
public interface CourseService {
    /**
     * Saves a course entity in the correspondent repository.
     * @param course the course entity to save
     */
    void saveCourse(Course course);

    /**
     * Fetches the list of all CourseName.
     * @return a list of CourseName
     */
    List<CourseName> getAllCoursesName();

    /**
     * Fetches the list of all courses (CourseName), held by a specific trainer.
     * @param name name of the trainer
     * @return a list of CourseName
     */
    List<CourseName> getCoursesNameByTrainer(String name);

    /**
     * Fetches the CourseName by time and day.
     * @param time time
     * @param day day
     * @return the CourseName
     */
    CourseName getCourseNameByTimeAndDay(LocalTime time, Day day);

    /**
     * Fetches the list of all courses (CourseName), held in a specific day.
     * @param day day
     * @return a list of CourseName
     */
    List<CourseName> getCoursesByDay(Day day);

    /**
     * Fetches the list of students' names (String) enrolled for a specific CourseName.
     * @param courseName the CourseName
     * @return a list of students' names
     */
    List<String> getListOfStudentsNamesFromCourse(CourseName courseName);

    /**
     * Fetches the number of students enrolled for a specific CourseName.
     * @param courseName the CourseName
     * @return the number of students
     */
    int getNumberOfAllStudentsFromCourse(CourseName courseName);

    /**
     * Fetches the list of all courses (CourseName), held in a specific day and studio.
     * @param day day
     * @param studio studio
     * @return a list of CourseName
     */
    List<CourseName> getCourseNameByDayAndStudio(Day day, Studio studio);
}
