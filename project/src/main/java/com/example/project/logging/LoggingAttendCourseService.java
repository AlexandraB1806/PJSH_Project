package com.example.project.logging;

import com.example.project.logging.event.AttendCourseEvent;
import com.example.project.logging.event.AttendCourseEventState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoggingAttendCourseService implements LoggingAttendCourse {
    private List<AttendCourseEvent> events;

    public LoggingAttendCourseService() {
        this.events = new ArrayList<>(100);
    }

    @Override
    @EventListener(condition = "#event.noSessionsPerformed == @eventConditionFilter.subscriptionLimit")
    public void loggingSessionsPerformed(AttendCourseEvent event) {
        events.add(event);

        System.out.println("You have performed " + event.getNoSessionsPerformed() + " sessions!");
    }

    @Override
    @EventListener
    public void loggingAttendCourseStatus(AttendCourseEvent event) {
        events.add(event);

        if (event.getAttendCourseEventState() == AttendCourseEventState.SUCCESS) {
            System.out.println("Remaining " + (event.getNoSessionsAvailable() - event.getNoSessionsPerformed()) + " sessions");
        }
        else {
            System.out.println("No more sessions left!");
        }
    }

    public List<AttendCourseEvent> getEvents() {
        return new ArrayList<>(events);
    }
}
