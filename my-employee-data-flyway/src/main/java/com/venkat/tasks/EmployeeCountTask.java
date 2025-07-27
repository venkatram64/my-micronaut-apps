package com.venkat.tasks;


import com.venkat.service.EmployeeService;
import io.micronaut.aop.Around;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.micronaut.SchedulerLock;

@Singleton
@Slf4j
@Around
public class EmployeeCountTask {

    private final EmployeeService employeeService;

    public EmployeeCountTask(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //@Scheduled(fixedRate = "5s")
    @Scheduled(cron = "*/10 * * * * *")  // Every 10 seconds for easier testing
    @SchedulerLock(
            name = "employeeCountTask",
            lockAtLeastFor = "PT5S",   // Lock for at least 5 seconds
            lockAtMostFor = "PT30S"    // Maximum lock duration 30 seconds
    )
    public void runEmployeeCount() {
        log.info("=== STARTING Employee Count Task === (Thread: {})", Thread.currentThread().getName());
        try {
            log.info("Simulating work for 3 seconds...");
            Thread.sleep(3000); // Simulate some work to test locking
            long count = employeeService.getEmployeeCount();
            log.info("Employee count completed: {}", count);
        } catch (Exception e) {
            log.error("Failed to execute employee count task", e);
        }
        log.info("=== FINISHED Employee Count Task ===");
    }
}
