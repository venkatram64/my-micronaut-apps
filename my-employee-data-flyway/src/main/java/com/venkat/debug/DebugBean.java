package com.venkat.debug;

import com.venkat.config.ShedLockConfig;
import io.micronaut.context.ApplicationContext;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.LockProvider;

@Singleton
@Slf4j
public class DebugBean {
    @Inject
    ApplicationContext context;

    public DebugBean() {
        log.info("DebugBean initialized");
    }

    @PostConstruct
    public void init() {
        log.info("ApplicationContext contains LockProvider: {}", context.containsBean(LockProvider.class));
        log.info("LockProvider beans: {}", context.getBeansOfType(LockProvider.class));
        log.info("ShedLockConfig bean exists: {}", context.containsBean(ShedLockConfig.class));
    }
}