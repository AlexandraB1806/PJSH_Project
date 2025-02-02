package com.example.project.service;

import com.example.project.entity.Course;
import com.example.project.entity.Student;
import com.example.project.entity.Subscription;
import com.example.project.enums.CourseName;
import com.example.project.enums.Day;
import com.example.project.repository.CourseRepository;
import com.example.project.repository.StudentRepository;
import com.example.project.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of StudentService.
 * Provides business logic for handling student-related operations.
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

    private SubscriptionRepository subscriptionRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, SubscriptionRepository subscriptionRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public StudentServiceImpl() {}

    @Override
    public int attendCourse(String studentName, CourseName courseName, Day day) throws Throwable {
        Student student = studentRepository.findByName(studentName);
        Subscription subscription = student.getSubscription();

        // Pointcut AOP
        System.out.println("Number of sessions performed for: " + studentName + " is: " + subscription.getNoSessionsPerformed() + " from " + subscription.getNoSessionsAvailable() + " available");
        System.out.println("Starting performed another one...");

        // No more sessions left for the student
        if (subscription.getNoSessionsPerformed() >= subscription.getNoSessionsAvailable()) {
            throw new Throwable("No more sessions left!");
        }

        // Choose a course & update the number of courses a student attends
        Course course = courseRepository.findByNameAndDay(courseName, day);
        student.addCourse(course);
        subscription.setNoSessionsPerformed(subscription.getNoSessionsPerformed() + 1);

        studentRepository.save(student);
        subscriptionRepository.save(subscription);

        return subscription.getNoSessionsPerformed();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void setSubscriptionRepository(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }
}
