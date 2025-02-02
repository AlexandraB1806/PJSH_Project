package com.example.project.service;

import com.example.project.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncNotificationService {
    @Value("${expirationDayLimit}")
    private int expirationDayLimitForNotification;

    public AsyncNotificationService() {}

    public CompletableFuture<Integer> notifyAboutExpiringSubscription(Student student) {
        // Check if the subscription expires in the next 3 days
        if (student.getSubscription() != null && daysUntilSubscriptionExpiration(student) <= expirationDayLimitForNotification) {
            sendPushNotification(student.getEmail(), "Subscription Notification", "Your subscription will expire soon!");
            return CompletableFuture.completedFuture(1);
        }
        return CompletableFuture.completedFuture(0);
    }

    private long daysUntilSubscriptionExpiration(Student student) {
        LocalDate currentDate = LocalDate.now();
        LocalDate subscriptionExpirationDate = student.getSubscription().getEndDate();
        return ChronoUnit.DAYS.between(currentDate, subscriptionExpirationDate);
    }

    public void sendPushNotification(String email, String notificationTitle, String message) {
        // Simulating sending notification time (5s)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(notificationTitle + " with the message: " + message + " was successfully sent to the email: " + email);
    }
}
