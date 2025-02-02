package com.example.project.logging.event;

import org.springframework.context.ApplicationEvent;

public class AttendCourseEvent extends ApplicationEvent {
    private int noSessionsAvailable;

    private int noSessionsPerformed;

    private AttendCourseEventState attendCourseEventState;

    public AttendCourseEvent(Object source, int noSessionsAvailable, int noSessionsPerformed, AttendCourseEventState state) {
        super(source);
        this.noSessionsPerformed = noSessionsPerformed;
        this.noSessionsAvailable = noSessionsAvailable;
        this.attendCourseEventState = state;
    }

    public int getNoSessionsAvailable() {
        return noSessionsAvailable;
    }

    public void setNoSessionsAvailable(int noSessionsAvailable) {
        this.noSessionsAvailable = noSessionsAvailable;
    }

    public int getNoSessionsPerformed() {
        return noSessionsPerformed;
    }

    public void setNoSessionsPerformed(int noSessionsPerformed) {
        this.noSessionsPerformed = noSessionsPerformed;
    }

    public AttendCourseEventState getAttendCourseEventState() {
        return attendCourseEventState;
    }

    public void setAttendCourseEventState(AttendCourseEventState attendCourseEventState) {
        this.attendCourseEventState = attendCourseEventState;
    }
}
