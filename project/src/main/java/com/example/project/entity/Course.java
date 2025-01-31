package com.example.project.entity;

import com.example.project.enums.CourseName;
import com.example.project.enums.Day;
import com.example.project.enums.Level;
import com.example.project.enums.Studio;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CourseName name;

    @Enumerated(value = EnumType.STRING)
    private Day day;

    private LocalTime time;

    @Enumerated(value = EnumType.STRING)
    private Studio studio;

    @Enumerated(value = EnumType.STRING)
    private Level level;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private Set<Student> students;

    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Trainer trainer;

    public Course() {}

    public Course(CourseName name, Day day, LocalTime time, Studio studio, Level level, Trainer trainer) {
        this.name = name;
        this.day = day;
        this.time = time;
        this.studio = studio;
        this.level = level;
        this.trainer = trainer;
    }

    public Course(Long id, CourseName name, Day day, LocalTime time, Studio studio, Level level, Trainer trainer) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.time = time;
        this.studio = studio;
        this.level = level;
        this.trainer = trainer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseName getName() {
        return name;
    }

    public void setName(CourseName name) {
        this.name = name;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
