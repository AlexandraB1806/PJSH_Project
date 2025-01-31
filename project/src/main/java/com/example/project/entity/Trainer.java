package com.example.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "trainer")
public class Trainer extends Person {
    private double salary;

    @OneToMany(mappedBy = "trainer")
    private Set<Course> courses;

    public Trainer() {}

    public Trainer(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public Trainer(int id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
