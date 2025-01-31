package com.example.project.repository;

import com.example.project.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Subscription entity.
 * Provides CRUD operations and custom query methods through JpaRepository.
 */
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    /**
     * Fetches the list of subscription entity by the start date.
     * @param startDate startDate
     * @return the subscription entities
     */
    List<Subscription> findByStartDate(LocalDate startDate);

    /**
     * Fetches the list of subscription entity by the end date.
     * @param endDate endDate
     * @return the subscription entities
     */
    List<Subscription> findByEndDate(LocalDate endDate);
}
