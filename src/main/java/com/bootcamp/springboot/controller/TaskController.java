package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.Task;
import com.bootcamp.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Task> taskList = taskService.getTasks();
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("taskList", taskList);
        return "Task";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveTask(@ModelAttribute("task") Task task){
        taskService.saveTask(task);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteTask(@RequestParam("taskId") long taskId) {
        taskService.deleteTask(taskId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping( value = "/update", method = RequestMethod.POST)
    public ModelAndView fetchTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }



}


