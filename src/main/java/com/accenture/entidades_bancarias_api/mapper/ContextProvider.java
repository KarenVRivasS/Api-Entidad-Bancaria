package com.accenture.entidades_bancarias_api.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextProvider implements ApplicationListener<ContextRefreshedEvent> {
    private static ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        applicationContext = event.getApplicationContext();
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}