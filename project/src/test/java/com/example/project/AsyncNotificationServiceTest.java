package com.example.project;

import com.example.project.entity.Course;
import com.example.project.entity.Student;
import com.example.project.entity.Subscription;
import com.example.project.enums.Status;
import com.example.project.service.AsyncNotificationService;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@SpringJUnitConfig
public class AsyncNotificationServiceTest {
    @Mock
    private AsyncNotificationService notificationService;

    @Test
    void testNotifyAboutExpiringSubscription() throws Exception {
        Set<Course> courseSet = new HashSet<>();
        Subscription subscription = new Subscription(0, 4, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 280);
        Student student = new Student("Maria Ionescu", "0725043791", "mariaaionescu@gmail.com",  subscription, courseSet);

        when(notificationService.notifyAboutExpiringSubscription(any())).thenReturn(CompletableFuture.completedFuture(1));

        CompletableFuture<Integer> resultFuture = notificationService.notifyAboutExpiringSubscription(student);
        verify(notificationService, times(1)).notifyAboutExpiringSubscription(eq(student));

        // Wait for async completion
        Integer result = resultFuture.get();

        Assertions.assertEquals(1, result);
    }
}
