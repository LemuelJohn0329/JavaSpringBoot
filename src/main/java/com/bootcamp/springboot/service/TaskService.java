package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.Task;
import com.bootcamp.springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;


    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    public Task getTaskById(long id) {
        return taskRepository.findById(id).get();
    }

}
