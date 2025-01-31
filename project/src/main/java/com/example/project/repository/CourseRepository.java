package com.example.project.repository;

import com.example.project.entity.Course;
import com.example.project.entity.Trainer;
import com.example.project.enums.CourseName;
import com.example.project.enums.Day;

import com.example.project.enums.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

/**
 * Repository interface for Course entity.
 * Provides CRUD operations and custom query methods through JpaRepository.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    /**
     * Fetches the set of the distinct course entities.
     * @param name the CourseName
     * @return a set of course entities
     */
    Set<Course> findByName(CourseName name);

    /**
     * Fetches the course entity by CourseName and day.
     * @param name the CourseName
     * @param day day
     * @return the course entity
     */
    Course findByNameAndDay(CourseName name, Day day);

    /**
     * Fetches the list of the course entities from a specific trainer entity.
     * @param trainer the trainer entity
     * @return a list of course entities
     */
    List<Course> findCourseByTrainer(Trainer trainer);

    /**
     * Fetches the course entity by time and day.
     * @param time time
     * @param day day
     * @return the course entity
     */
    Course findCourseNameByTimeAndDay(LocalTime time, Day day);

    /**
     * Fetches the list of course entities from a specific day.
     * @param day day
     * @return a list of course entities
     */
    List<Course> findCoursesByDay(Day day);

    /**
     * Fetches the list of the course entities from a specific day and studio.
     * @param day day
     * @param studio studio
     * @return a list of course entities
     */
    List<Course> findByDayAndStudio(Day day, Studio studio);
}
