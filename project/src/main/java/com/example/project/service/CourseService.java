package com.example.project.service;

import com.example.project.entity.Course;
import com.example.project.entity.Trainer;
import com.example.project.entity.Student;
import com.example.project.enums.CourseName;
import com.example.project.enums.Day;
import com.example.project.enums.Studio;
import com.example.project.repository.CourseRepository;
import com.example.project.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TrainerRepository trainerRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, TrainerRepository trainerRepository) {
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public List<CourseName> getAllCoursesName() {
        return courseRepository.findAll().stream().map(Course::getName).collect(Collectors.toList());
    }

    public List<CourseName> getCoursesByTrainerName(String name) {
        Trainer trainer = trainerRepository.findByName(name);

        return courseRepository.findCourseByTrainer(trainer).stream().map(Course::getName).collect(Collectors.toList());
    }

    public CourseName getCourseNameByTimeAndDay(LocalTime time, Day day) {
        return courseRepository.findCourseNameByTimeAndDay(time, day).getName();
    }

    public List<CourseName> getCoursesByDay(Day day) {
        return courseRepository.findCoursesByDay(day).stream().map(Course::getName).collect(Collectors.toList());
    }

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

    public int getNumberOfAllStudentsFromCourse(CourseName courseName) {
        return getListOfStudentsNamesFromCourse(courseName).size();
    }

    public List<CourseName> getCourseNameByDayAndStudio(Day day, Studio studio) {
        return courseRepository.findByDayAndStudio(day, studio).stream().map(Course::getName).collect(Collectors.toList());
    }
}
