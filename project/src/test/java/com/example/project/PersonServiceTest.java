package com.example.project;

import com.example.project.entity.Course;
import com.example.project.entity.Student;
import com.example.project.entity.Subscription;
import com.example.project.entity.Trainer;
import com.example.project.enums.CourseName;
import com.example.project.enums.Day;
import com.example.project.enums.Status;
import com.example.project.repository.CourseRepository;
import com.example.project.repository.StudentRepository;
import com.example.project.repository.SubscriptionRepository;
import com.example.project.repository.TrainerRepository;
import com.example.project.service.CourseServiceImpl;
import com.example.project.service.StudentServiceImpl;
import com.example.project.service.TrainerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class PersonServiceTest {
    @Mock
    private TrainerRepository trainerRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private SubscriptionRepository subscriptionRepository;

    private TrainerServiceImpl trainerService;
    private StudentServiceImpl studentService;
    private CourseServiceImpl courseService;

    private Trainer trainer;

    private Student student1;
    private Student student2;

    private Subscription subscription1;
    private Subscription subscription2;

    private Course course;

    @BeforeEach
    void setUp() {
        trainerService = new TrainerServiceImpl(trainerRepository);
        trainer = new Trainer(2, "Popescu Adelina", 2000);

        courseService = new CourseServiceImpl(courseRepository, trainerRepository);

        studentService = new StudentServiceImpl();
        studentService.setStudentRepository(studentRepository);
        studentService.setSubscriptionRepository(subscriptionRepository);
        studentService.setCourseRepository(courseRepository);

        student1 = new Student("Maria Ionescu", "0725043791", "mariaaionescu@gmail.com", null, new HashSet<>());
        student2 = new Student("Alexandru Popescu", "0725043792", "popescu.alex@gmail.com", null, new HashSet<>());

        subscription1 = new Subscription(0, 4, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 280);
        student1.setSubscription(subscription1);

        subscription2 = new Subscription(0, 8, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 400);
        student2.setSubscription(subscription2);

        course = new Course();
        course.setName(CourseName.Zumba);
        course.setStudents(Set.of(student1, student2));
    }

    @Test
    void testGetTrainerSalaryByName() {
        when(trainerRepository.findSalaryByName(trainer.getName())).thenReturn(trainer.getSalary());

        double actualSalary = trainerService.getSalaryByName(trainer.getName());
        double expectedSalary = trainer.getSalary();

        Assertions.assertEquals(actualSalary, expectedSalary);
    }

    @Test
    void testAttendCourse() throws Throwable {
        when(studentRepository.findByName(student1.getName())).thenReturn(student1);
        when(courseRepository.findByNameAndDay(CourseName.Zumba, Day.WEDNESDAY)).thenReturn(course);

        int sessionsPerf = studentService.attendCourse("Maria Ionescu", CourseName.Zumba, Day.WEDNESDAY);
        int expected = 1;
        Assertions.assertEquals(sessionsPerf, expected);
    }

    @Test
    void testGetNumOfStudentsCourse() {
        when(courseRepository.findByName(CourseName.Zumba)).thenReturn(Set.of(course));

        int numberOfStudents = courseService.getNumberOfAllStudentsFromCourse(CourseName.Zumba);
        int expected = course.getStudents().size();

        Assertions.assertEquals(numberOfStudents, expected);
    }
}
