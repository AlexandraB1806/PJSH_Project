package com.example.project.logging;

import com.example.project.logging.event.AttendCourseEvent;

public interface LoggingAttendCourse {
    void loggingSessionsPerformed(AttendCourseEvent event);

    void loggingAttendCourseStatus(AttendCourseEvent event);
}
