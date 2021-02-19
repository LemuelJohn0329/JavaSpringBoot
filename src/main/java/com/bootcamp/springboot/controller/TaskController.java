package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.Task;
import com.bootcamp.springboot.service.TaskService;
import com.sun.beans.finder.BeanInfoFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }



}


