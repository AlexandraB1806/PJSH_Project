package com.example.project.database;

import com.example.project.entity.Course;
import com.example.project.entity.Student;
import com.example.project.entity.Subscription;
import com.example.project.enums.*;
import com.example.project.entity.Trainer;
import com.example.project.repository.CourseRepository;
import com.example.project.repository.StudentRepository;
import com.example.project.repository.SubscriptionRepository;
import com.example.project.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseCreator implements CommandLineRunner {
    private final CourseRepository courseRepository;
    private final TrainerRepository trainerRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final StudentRepository studentRepository;

    @Value("${populateDatabase}")
    private boolean populateDatabase;

    public DatabaseCreator(CourseRepository courseRepository, TrainerRepository trainerRepository, SubscriptionRepository subscriptionRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {
        if (populateDatabase) {
            this.addTrainers();
            this.addCourses();
            this.addSubscription();
            this.addStudents();
        }
    }

    private void addTrainers() {
        {
            Trainer trainer = new Trainer("Ioana Petre", 2500);
            trainerRepository.save(trainer);
        }

        {
            Trainer trainer = new Trainer("Boldojar Adelina", 2000);
            trainerRepository.save(trainer);
        }

        {
            Trainer trainer = new Trainer("Viviana Meda", 4000);
            trainerRepository.save(trainer);
        }

        {
            Trainer trainer = new Trainer("Genil Hasim", 2700);
            trainerRepository.save(trainer);
        }

        {
            Trainer trainer = new Trainer("Alin Piciu", 3000);
            trainerRepository.save(trainer);
        }

        {
            Trainer trainer = new Trainer("Rebecca Bumputu", 2800);
            trainerRepository.save(trainer);
        }

        {
            Trainer trainer = new Trainer("Awad Chady", 3200);
            trainerRepository.save(trainer);
        }

        {
            Trainer trainer = new Trainer("Ana Georgescu", 1800);
            trainerRepository.save(trainer);
        }

        {
            Trainer trainer = new Trainer("Bogdan Boanta", 5000);
            trainerRepository.save(trainer);
        }

        {
            Trainer trainer = new Trainer("Andra Gheorghe Cocuta", 4800);
            trainerRepository.save(trainer);
        }
    }

    private void addCourses() {
        {
            Course course = new Course(CourseName.Ballet, Day.MONDAY, LocalTime.of(17, 0), Studio.Studio1, Level.INTERMEDIATE, trainerRepository.findByName("Ioana Petre"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.HipHop, Day.MONDAY, LocalTime.of(18, 0), Studio.Studio1, Level.INTERMEDIATE, trainerRepository.findByName("Boldojar Adelina"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Salsa, Day.MONDAY, LocalTime.of(19, 0), Studio.Studio2, Level.ADVANCED, trainerRepository.findByName("Viviana Meda"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Flamenco, Day.MONDAY, LocalTime.of(20, 30), Studio.Studio2, Level.INTERMEDIATE, trainerRepository.findByName("Viviana Meda"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Jazz, Day.TUESDAY, LocalTime.of(17, 0), Studio.Studio1, Level.BEGINNER, trainerRepository.findByName("Viviana Meda"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Folk, Day.TUESDAY, LocalTime.of(18, 0), Studio.Studio1, Level.INTERMEDIATE, trainerRepository.findByName("Genil Hasim"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Folk, Day.TUESDAY, LocalTime.of(19, 0), Studio.Studio1, Level.INTERMEDIATE, trainerRepository.findByName("Alin Piciu"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Bachata, Day.TUESDAY, LocalTime.of(19, 0), Studio.Studio2, Level.INTERMEDIATE, trainerRepository.findByName("Rebecca Bumputu"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Fusion, Day.TUESDAY, LocalTime.of(20, 30), Studio.Studio2, Level.INTERMEDIATE, trainerRepository.findByName("Awad Chady"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Zumba, Day.WEDNESDAY, LocalTime.of(17, 0), Studio.Studio1, Level.BEGINNER, trainerRepository.findByName("Ioana Petre"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.ModernDance, Day.WEDNESDAY, LocalTime.of(18, 0), Studio.Studio1, Level.BEGINNER, trainerRepository.findByName("Boldojar Adelina"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Zumba, Day.WEDNESDAY, LocalTime.of(19, 30), Studio.Studio1, Level.BEGINNER, trainerRepository.findByName("Ana Georgescu"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.BreakDance, Day.WEDNESDAY, LocalTime.of(19, 0), Studio.Studio2, Level.INTERMEDIATE, trainerRepository.findByName("Bogdan Boanta"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.StreetDance, Day.WEDNESDAY, LocalTime.of(20, 0), Studio.Studio2, Level.INTERMEDIATE, trainerRepository.findByName("Andra Gheorghe Cocuta"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Fusion, Day.THURSDAY, LocalTime.of(17, 0), Studio.Studio1, Level.BEGINNER, trainerRepository.findByName("Viviana Meda"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Jazz, Day.THURSDAY, LocalTime.of(18, 0), Studio.Studio1, Level.INTERMEDIATE, trainerRepository.findByName("Genil Hasim"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Zumba, Day.THURSDAY, LocalTime.of(19, 0), Studio.Studio1, Level.INTERMEDIATE, trainerRepository.findByName("Alin Piciu"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.Flamenco, Day.THURSDAY, LocalTime.of(19, 0), Studio.Studio2, Level.ADVANCED, trainerRepository.findByName("Bogdan Boanta"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.BreakDance, Day.THURSDAY, LocalTime.of(20, 30), Studio.Studio2, Level.ADVANCED, trainerRepository.findByName("Alin Piciu"));
            courseRepository.save(course);
        }

        {
            Course course = new Course(CourseName.HipHop, Day.FRIDAY, LocalTime.of(19, 0), Studio.Studio2, Level.BEGINNER, trainerRepository.findByName("Viviana Meda"));
            courseRepository.save(course);
        }
    }

    private void addSubscription() {
        {
            Subscription subscription = new Subscription(0, 4, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 280);
            subscriptionRepository.save(subscription);
        }
        {
            Subscription subscription = new Subscription(0, 8, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 400);
            subscriptionRepository.save(subscription);
        }
        {
            Subscription subscription = new Subscription(0, 12, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 500);
            subscriptionRepository.save(subscription);
        }
        {
            Subscription subscription = new Subscription(0, 18, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 650);
            subscriptionRepository.save(subscription);
        }
        {
            Subscription subscription = new Subscription(0, 80, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 880);
            subscriptionRepository.save(subscription);
        }
        {
            Subscription subscription = new Subscription(0, 1, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 75);
            subscriptionRepository.save(subscription);
        }
    }

    private void addStudents() {
        {
            Set<Course> courseSet = new HashSet<>();
            Course course = courseRepository.findByNameAndDay(CourseName.Ballet, Day.MONDAY);
            courseSet.add(course);
            course = courseRepository.findByNameAndDay(CourseName.Flamenco, Day.MONDAY);
            courseSet.add(course);
            course = courseRepository.findByNameAndDay(CourseName.Bachata, Day.TUESDAY);
            courseSet.add(course);
            course = courseRepository.findByNameAndDay(CourseName.ModernDance, Day.WEDNESDAY);
            courseSet.add(course);
            course = courseRepository.findByNameAndDay(CourseName.BreakDance, Day.WEDNESDAY);
            courseSet.add(course);

            Subscription subscription = subscriptionRepository.findById(1L).orElse(null);

            Student student = new Student("Maria Ionescu", "0725043791", "mariaaionescu@gmail.com", subscription, courseSet);
            studentRepository.save(student);
        }

        {
            Set<Course> courseSet = new HashSet<>(courseRepository.findCourseByTrainer(trainerRepository.findByName("Bogdan Boanta")));

            Subscription subscription = subscriptionRepository.findById(2L).orElse(null);

            Student student = new Student("Alexandru Popescu", "0725043792", "popescu.alex@gmail.com", subscription, courseSet);
            studentRepository.save(student);
        }

        {
            Set<Course> courseSet = new HashSet<>(courseRepository.findCoursesByDay(Day.WEDNESDAY));

            Subscription subscription = subscriptionRepository.findById(3L).orElse(null);

            Student student = new Student("Ana Radu-Mihalcea", "0725043793", "anuscaradu@gmail.com", subscription, courseSet);
            studentRepository.save(student);
        }

        {
            Set<Course> courseSet = new HashSet<>(courseRepository.findByDayAndStudio(Day.THURSDAY, Studio.Studio1));

            Subscription subscription = subscriptionRepository.findById(4L).orElse(null);

            Student student = new Student("Gabriela Serban", "0725043794", "gabi_serban@gmail.com", subscription, courseSet);
            studentRepository.save(student);
        }

        {
            Set<Course> courseSet = courseRepository.findByName(CourseName.HipHop);

            Subscription subscription = subscriptionRepository.findById(5L).orElse(null);

            Student student = new Student("Eduard Marin", "0725043795", "ediiiiii@gmail.com", subscription, courseSet);
            studentRepository.save(student);
        }
    }
}