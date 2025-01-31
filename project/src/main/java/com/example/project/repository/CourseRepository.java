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

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Set<Course> findByName(CourseName name);

    Course findByNameAndDay(CourseName name, Day day);

    List<Course> findCourseByTrainer(Trainer trainer);

    Course findCourseNameByTimeAndDay(LocalTime time, Day day);

    List<Course> findCoursesByDay(Day day);

    List<Course> findByDayAndStudio(Day day, Studio studio);
}
