package com.example.project.service;

import com.example.project.entity.Student;
import com.example.project.entity.Subscription;
import com.example.project.enums.Status;
import com.example.project.repository.StudentRepository;
import com.example.project.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of SubscriptionService.
 * Provides business logic for handling course-related operations.
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final StudentRepository studentRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, StudentRepository studentRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Subscription> getSubscriptionsByStartDate(LocalDate startDate) {
        return subscriptionRepository.findByStartDate(startDate);
    }

    @Override
    public List<String> getListOfStudentsBySubscriptionEndDate(LocalDate endDate) {
        List<Subscription> subscriptions = subscriptionRepository.findByEndDate(endDate);
        List<String> students = new ArrayList<>();

        for (Subscription subscription: subscriptions) {
            try {
                students.add(subscription.getStudent().getName());
            }
            catch (Exception e){}
        }

        return students;
    }

    @Override
    public Status expiredSubscription(String studentName) {
        Student student = studentRepository.findByName(studentName);
        Subscription subscription = student.getSubscription();

        if (subscription.getEndDate().isBefore(LocalDate.now())) {
            subscription.setStatus(Status.EXPIRED);

            student.setSubscription(subscription);

            subscriptionRepository.save(subscription);
            studentRepository.save(student);
        }

        return studentRepository.findByName(studentName).getSubscription().getStatus();
    }

    @Override
    public Status exceededSubscription(String studentName) {
        Student student = studentRepository.findByName(studentName);
        Subscription subscription = student.getSubscription();

        if (subscription.getNoSessionsPerformed() >= subscription.getNoSessionsAvailable()) {
            subscription.setStatus(Status.EXCEEDED);

            student.setSubscription(subscription);

            subscriptionRepository.save(subscription);
            studentRepository.save(student);
        }

        return studentRepository.findByName(studentName).getSubscription().getStatus();
    }
}
