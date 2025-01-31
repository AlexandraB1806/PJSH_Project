package com.example.project.service;

import com.example.project.entity.Subscription;
import com.example.project.enums.Status;

import java.time.LocalDate;
import java.util.List;

/**
 * Service interface for Subscription entity.
 * Defines methods for CRUD operations and additional business logic.
 */
public interface SubscriptionService {
    /**
     * Fetches the list of subscription entity by the start date.
     * @param startDate start date
     * @return the subscription entities
     */
    List<Subscription> getSubscriptionsByStartDate(LocalDate startDate);

    /**
     * Retrieves all the subscriptions that expire at a specific date and
     * searches for the students that are in this situation.
     * @param endDate end date
     * @return the list of students' names
     */
    List<String> getListOfStudentsBySubscriptionEndDate(LocalDate endDate);

    /**
     * Marks the subscription status as EXPIRED for a specific student (if it is expired).
     * @param studentName the student
     * @return the EXPIRED status
     */
    Status expiredSubscription(String studentName);

    /**
     * Marks the subscription status as EXCEEDED for a specific student (if the limit
     * was exceeded).
     * @param studentName the student
     * @return the EXCEEDED status
     */
    Status exceededSubscription(String studentName);
}
