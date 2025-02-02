package com.example.project.logging.event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventConditionFilter {
    @Value("${logging.subscriptionLimit}")
    public double subscriptionLimit;
}
