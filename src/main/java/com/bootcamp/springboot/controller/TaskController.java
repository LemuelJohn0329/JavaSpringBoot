package com.bootcamp.springboot.controller;

import ch.qos.logback.core.boolex.EvaluationException;
import com.bootcamp.springboot.service.TaskService;
import com.bootcamp.springboot.model.Task;
import com.sun.org.apache.xpath.internal.objects.XString;
import com.sun.org.apache.xpath.internal.objects.XStringForChars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sound.midi.MidiDevice;
import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Map;

@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /*@GetMapping("/all")
        public ResponseEntity<List<Task>> get() {
        List<Task> tasks = this.taskService.getallTask();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
        }*/

    @GetMapping("/")
    public String task(Model model) {
        List<Task> task = taskService.getallTask();
        model.addAttribute("task", task);
        return "Task";
    }



   @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public ModelAndView addTask(@ModelAttribute("task") Task task) {
        System.out.println(task);
       ModelAndView modelAndView = new ModelAndView();
        if (taskService.addTask(task) == false) {
            modelAndView.setViewName("TaskAdd");
        }
        return modelAndView;
   }

   @GetMapping("/add")
    public String add(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "TaskAdd";
   }

   @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteTask(@RequestParam("taskId") long taskId, Model model) {

        this.taskService.removeTask(taskId);
       List<Task> task = taskService.getallTask();
       model.addAttribute("task", task);
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("Task");
       return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView update(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("TaskUpdate");
        return modelAndView;
    }
}


