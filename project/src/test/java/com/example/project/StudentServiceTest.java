package com.example.project;

import com.example.project.entity.Course;
import com.example.project.enums.Day;
import com.example.project.enums.Status;
import com.example.project.enums.CourseName;
import com.example.project.entity.Student;
import com.example.project.entity.Subscription;
import com.example.project.repository.CourseRepository;
import com.example.project.repository.StudentRepository;
import com.example.project.repository.SubscriptionRepository;
import com.example.project.service.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.HashSet;

import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private CourseRepository courseRepository;
    @Mock
    private SubscriptionRepository subscriptionRepository;

    private StudentServiceImpl studentService;

    private Student student;

    private Subscription subscription;

    private Course course;

    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl();
        studentService.setStudentRepository(studentRepository);
        studentService.setSubscriptionRepository(subscriptionRepository);
        studentService.setCourseRepository(courseRepository);

        student = new Student();
        student.setName("Ana Radu");
        student.setCourses(new HashSet<>());
        subscription = new Subscription(0, 4, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 280);
        student.setSubscription(subscription);

        course = new Course();
    }

    @Test
    void testAttendCourse() throws Throwable {
        when(studentRepository.findByName(student.getName())).thenReturn(student);
        when(courseRepository.findByNameAndDay(CourseName.Bachata, Day.MONDAY)).thenReturn(course);

        Integer sessionsPerf = studentService.attendCourse("Ana Radu", CourseName.Bachata, Day.MONDAY);
        Integer expected = 1;
        Assertions.assertEquals(sessionsPerf, expected);
    }
}
