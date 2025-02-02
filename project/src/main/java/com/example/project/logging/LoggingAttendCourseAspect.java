package com.example.project.logging;

import com.example.project.entity.Student;
import com.example.project.entity.Subscription;
import com.example.project.logging.event.AttendCourseEvent;
import com.example.project.logging.event.AttendCourseEventState;
import com.example.project.repository.StudentRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAttendCourseAspect {
    private final ApplicationContext applicationContext;
    private final StudentRepository studentRepository;

    public LoggingAttendCourseAspect(ApplicationContext applicationContext, StudentRepository studentRepository) {
        this.applicationContext = applicationContext;
        this.studentRepository = studentRepository;
    }

    @Pointcut("execution(* com.example.project.service.*.attendCourse(..))")
    public void anyAttendCourse() {}

    // Advice
    @Around("anyAttendCourse()")
    public Object logAttendCourse(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] methodArgs = joinPoint.getArgs();

        String studentName = ((String) (methodArgs[0]));

        Student student = studentRepository.findByName(studentName);
        Subscription subscription = student.getSubscription();

        Object result;
        try {
            result = joinPoint.proceed();
            applicationContext.publishEvent(new AttendCourseEvent("ATTEND COURSE EVENT", subscription.getNoSessionsAvailable(), (int) result, AttendCourseEventState.SUCCESS));
            return result;
        } catch (Throwable e) {
            applicationContext.publishEvent(new AttendCourseEvent("ATTEND COURSE EVENT", subscription.getNoSessionsAvailable(), subscription.getNoSessionsPerformed(), AttendCourseEventState.FAILED));
            throw e;
        }
    }
}
