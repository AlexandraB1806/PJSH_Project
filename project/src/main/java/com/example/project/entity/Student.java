package com.example.project.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "student")
public class Student extends Person {
    private String phoneNumber;
    private String email;

    @OneToOne
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private Subscription subscription;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public Student() {}

    public Student(String name, String phoneNumber, String email, Subscription subscription, Set<Course> courses) {
        super(name);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.subscription = subscription;
        this.courses = courses;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
