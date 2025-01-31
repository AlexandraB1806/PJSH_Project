package com.example.project.database;

import com.example.project.entity.Course;
import com.example.project.enums.CourseName;
import com.example.project.entity.Trainer;
import com.example.project.enums.Day;
import com.example.project.enums.Studio;
import com.example.project.enums.Level;
import com.example.project.repository.CourseRepository;
import com.example.project.repository.TrainerRepository;
import com.example.project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class DatabaseCreator implements CommandLineRunner {
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private TrainerRepository trainerRepository;
    
    @Autowired
    private CourseService courseService;

    @Value("${populateDatabase}")
    private boolean populateDatabase;

    public DatabaseCreator() {}

    public DatabaseCreator(CourseRepository courseRepository, TrainerRepository trainerRepository, CourseService courseService) {
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
        this.courseService = courseService;
    }

    {
        this.courseRepository = courseRepository;
        this.trainerRepository = trainerRepository;
        this.courseService = courseService;
    }
    
    @Override
    public void run(String... args) throws Exception {
        if (populateDatabase) {
            this.addTrainers();
            this.addCourses();
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
            Course course = new Course( CourseName.HipHop, Day.MONDAY, LocalTime.of(18, 0), Studio.Studio1, Level.INTERMEDIATE, trainerRepository.findByName("Boldojar Adelina"));
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
}