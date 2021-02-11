package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {

    List<Task> taskList = new ArrayList<Task>(Arrays.asList(
            new Task(1,"Clean the house", "02/20/2021"),
            new Task(1,"Go to te grocery", "02/21/2021"),
            new Task(1,"Exercise", "02/22/2021")
    ));

    public List<Task> getallTask() {
        return taskList;
    }

}
