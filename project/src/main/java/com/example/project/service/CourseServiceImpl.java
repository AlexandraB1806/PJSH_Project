package com.example.project.service;

import com.example.project.entity.Course;
import com.example.project.entity.Student;
import com.example.project.entity.Trainer;
import com.example.project.enums.CourseName;
import com.example.project.enums.Day;
import com.example.project.enums.Studio;
import com.example.project.repository.CourseRepository;
import com.example.project.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of CourseService.
 * Provides business logic for handling course-related operations.
 */
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final TrainerRepository trainerRepository;

    public CourseServiceImpl(CourseRepository courseRepository, TrainerRepository trainerRepository) {
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<CourseName> getAllCoursesName() {
        return courseRepository.findAll().stream().map(Course::getName).collect(Collectors.toList());
    }

    @Override
    public List<CourseName> getCoursesNameByTrainer(String name) {
        Trainer trainer = trainerRepository.findByName(name);

        return courseRepository.findCourseByTrainer(trainer).stream().map(Course::getName).collect(Collectors.toList());
    }

    @Override
    public CourseName getCourseNameByTimeAndDay(LocalTime time, Day day) {
        return courseRepository.findCourseNameByTimeAndDay(time, day).getName();
    }

    @Override
    public List<CourseName> getCoursesByDay(Day day) {
        return courseRepository.findCoursesByDay(day).stream().map(Course::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> getListOfStudentsNamesFromCourse(CourseName courseName) {
        // Get all course intervals
        List<Course> courses = courseRepository.findByName(courseName).stream().toList();
        Set<String> allStudents = new HashSet<>();

        for (Course course : courses) {
            List<String> students = course.getStudents().stream().map(Student::getName).toList();
            allStudents.addAll(students);
        }

        return allStudents.stream().toList();
    }

    @Override
    public int getNumberOfAllStudentsFromCourse(CourseName courseName) {
        return getListOfStudentsNamesFromCourse(courseName).size();
    }

    @Override
    public List<CourseName> getCourseNameByDayAndStudio(Day day, Studio studio) {
        return courseRepository.findByDayAndStudio(day, studio).stream().map(Course::getName).collect(Collectors.toList());
    }
}
