package com.example.project;

import com.example.project.entity.Student;
import com.example.project.entity.Trainer;
import com.example.project.entity.Subscription;
import com.example.project.entity.Course;
import com.example.project.enums.*;
import com.example.project.repository.CourseRepository;
import com.example.project.repository.TrainerRepository;
import com.example.project.service.CourseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class CourseServiceTest {
    @Mock
    private CourseRepository courseRepository;

    @Mock
    private TrainerRepository trainerRepository;

    private CourseServiceImpl courseService;

    private Trainer trainer1;

    private Course ballet1;
    private Course ballet2;
    private Course flamenco;
    private Course bachata;

    @BeforeEach
    void setUp() {
        courseService = new CourseServiceImpl(courseRepository, trainerRepository);

        ballet1 = new Course(1L, CourseName.Ballet, Day.MONDAY, LocalTime.of(19, 0), Studio.Studio1, Level.INTERMEDIATE,  trainerRepository.findByName("Viviana Meda"));
        flamenco = new Course(2L, CourseName.Flamenco, Day.TUESDAY, LocalTime.of(19, 0), Studio.Studio1, Level.INTERMEDIATE, trainerRepository.findByName("Alin Piciu"));
        bachata = new Course(3L, CourseName.Bachata, Day.TUESDAY, LocalTime.of(17, 0), Studio.Studio1, Level.BEGINNER, trainerRepository.findByName("Viviana Meda"));
        ballet2 = new Course(1L, CourseName.Ballet, Day.FRIDAY, LocalTime.of(19, 0), Studio.Studio2, Level.BEGINNER,  trainerRepository.findByName("Viviana Meda"));

        trainer1 = new Trainer(3, "Viviana Meda", 4000);
    }

    @Test
    void testGetAllCoursesName() {
        when(courseRepository.findAll()).thenReturn(List.of(ballet1, flamenco));

        List<CourseName> actualNames = courseService.getAllCoursesName();
        List<CourseName> expectedNames = List.of(CourseName.Ballet, CourseName.Flamenco);

        Assertions.assertIterableEquals(actualNames, expectedNames);
    }

    @Test
    void testGetCoursesNameByTrainer() {
        when(trainerRepository.findByName(trainer1.getName())).thenReturn(trainer1);
        when(courseRepository.findCourseByTrainer(trainer1)).thenReturn(List.of(flamenco, ballet1));

        List<CourseName> actualNames = courseService.getCoursesNameByTrainer("Viviana Meda");
        actualNames.sort(Comparator.comparing(CourseName::toString));
        List<CourseName> expectedNames = List.of(CourseName.Ballet, CourseName.Flamenco);

        Assertions.assertIterableEquals(actualNames, expectedNames);
    }

    @Test
    void testGetCourseNameByTimeAndDay() {
        when(courseRepository.findCourseNameByTimeAndDay(bachata.getTime(), bachata.getDay())).thenReturn(bachata);

        CourseName actualName = courseService.getCourseNameByTimeAndDay(bachata.getTime(), bachata.getDay());
        CourseName expectedName = bachata.getName();

        Assertions.assertEquals(actualName, expectedName);
    }

    @Test
    void testGetCoursesByDay() {
        when(courseRepository.findCoursesByDay(flamenco.getDay())).thenReturn(List.of(bachata, flamenco));

        List<CourseName> actualNames = courseService.getCoursesByDay(flamenco.getDay());
        actualNames.sort(Comparator.comparing(CourseName::toString));
        List<CourseName> expectedNames = List.of(bachata.getName(), flamenco.getName());

        Assertions.assertIterableEquals(actualNames, expectedNames);
    }

    @Test
    void testSaveCourse() {
        courseService.saveCourse(ballet1);

        verify(courseRepository).save(ballet1);
    }

    @Test
    void testGetListOfStudentsNamesFromCourse() {
        Subscription subscription = new Subscription(0, 8, Status.ACTIVE, LocalDate.now(), LocalDate.now(), 400);

        Student student1 = new Student("Ioana Popescu", "0725043791", "user1@gmail.com", subscription, Set.of(ballet1, ballet2, flamenco));
        Student student2 = new Student("Miruna Enescu", "0725043792", "user2@gmail.com", subscription, Set.of(ballet2));

        ballet1.setStudents(Set.of(student1));
        ballet2.setStudents(Set.of(student1, student2));

        when(courseRepository.findByName(ballet1.getName())).thenReturn(Set.of(ballet1, ballet2));

        List<String> actualNames = new ArrayList<>(courseService.getListOfStudentsNamesFromCourse(ballet2.getName()));
        Collections.sort(actualNames);
        List<String> expectedNames = new ArrayList<>(List.of(student1.getName(), student2.getName()));
        Collections.sort(expectedNames);

        Assertions.assertIterableEquals(actualNames, expectedNames);
    }

    @Test
    void testGetCourseNameByDayAndStudio() {
        when(courseRepository.findByDayAndStudio(bachata.getDay(), bachata.getStudio())).thenReturn(List.of(bachata, flamenco));

        List<CourseName> actualNames = courseService.getCourseNameByDayAndStudio(bachata.getDay(), bachata.getStudio());
        actualNames.sort(Comparator.comparing(CourseName::toString));

        List<CourseName> expectedNames = List.of(bachata.getName(), flamenco.getName());

        Assertions.assertIterableEquals(actualNames, expectedNames);
    }
}
