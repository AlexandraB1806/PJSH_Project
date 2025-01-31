package com.example.project;

import com.example.project.entity.Student;
import com.example.project.entity.Subscription;
import com.example.project.enums.Status;
import com.example.project.repository.StudentRepository;
import com.example.project.repository.SubscriptionRepository;
import com.example.project.service.SubscriptionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class SubscriptionServiceTest {
    @Mock
    private SubscriptionRepository subscriptionRepository;

    @Mock
    private StudentRepository studentRepository;

    private SubscriptionServiceImpl subscriptionService;

    private Subscription subscription;

    private Student student;

    @BeforeEach
    void setUp() {
        subscriptionService = new SubscriptionServiceImpl(subscriptionRepository, studentRepository);
        subscription = new Subscription(0, 80, Status.ACTIVE, LocalDate.now(), LocalDate.now().plusMonths(1), 880);
        student = new Student("Maria Ionescu", "0725043791", "user1@gmail.com", subscription, Set.of());
        subscription.setStudent(student);
    }

    @Test
    void testGetSubscriptionsByEndDate() {
        when(subscriptionRepository.findByEndDate(subscription.getEndDate())).thenReturn(List.of(student.getSubscription()));

        List<String> actual = subscriptionService.getListOfStudentsBySubscriptionEndDate(subscription.getEndDate());
        List<String> expected = List.of(student.getName());

        Assertions.assertIterableEquals(actual, expected);
    }

    @Test
    void testGetSubscriptionsByStartDate() {
        when(subscriptionRepository.findByStartDate(subscription.getStartDate())).thenReturn(List.of(subscription));

        List<Subscription> actual = subscriptionService.getSubscriptionsByStartDate(subscription.getStartDate());
        List<Subscription> expected = List.of(subscription);

        Assertions.assertIterableEquals(actual, expected);
    }

    @Test
    void testExpiredSubscription() {
        // Change subscription date
        subscription.setEndDate(subscription.getEndDate().minusMonths(10));

        student.setSubscription(subscription);

        when(studentRepository.findByName(student.getName())).thenReturn(student);

        Status actual = subscriptionService.expiredSubscription(student.getName());
        Status expected = Status.EXPIRED;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void testExceededSubscription() {
        // Change subscription date
        subscription.setNoSessionsPerformed(subscription.getNoSessionsAvailable() + 1);

        student.setSubscription(subscription);

        when(studentRepository.findByName(student.getName())).thenReturn(student);

        Status actual = subscriptionService.exceededSubscription(student.getName());
        Status expected = Status.EXCEEDED;

        Assertions.assertEquals(actual, expected);
    }
}
