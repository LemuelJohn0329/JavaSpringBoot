package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.service.TaskService;
import com.bootcamp.springboot.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
        public ResponseEntity<List<Task>> get() {
        List<Task> tasks = this.taskService.getallTask();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
        }

    @GetMapping("/task")
    public String task(Model model) {
        List<Task> task = taskService.getallTask();
        model.addAttribute("task",task);
        return "Task";
    }

    }


