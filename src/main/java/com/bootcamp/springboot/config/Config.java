package com.bootcamp.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.bootcamp.springboot.service.TaskService;

@Component
public class Config {

    @Bean
    public TaskService getTaskService() {
        return new TaskService();
    }
}
