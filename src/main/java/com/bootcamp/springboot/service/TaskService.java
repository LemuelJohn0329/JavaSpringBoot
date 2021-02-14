package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {

    List<Task> taskList = new ArrayList<Task>(Arrays.asList(
    ));

    public List<Task> getallTask() {
        return taskList;
    }

    public Boolean addTask(Task task) {
        boolean isTaskIdExist = false;
        for (Task item: taskList) {
            if (item.getTaskId() == task.getTaskId()) {
                isTaskIdExist = true;
                task.setTaskIdExist(true);
                System.out.println("Exist");
            }
        }
        if (isTaskIdExist == false) {
            task.setTaskIdExist(false);
            taskList.add(new Task(task.getTaskId(), task.getDescription(), task.getDate()));
            System.out.println("Not Exist");
        }
        return isTaskIdExist;
    }

    public void removeTask(long taskId) {
       taskList.removeIf( item -> item.getTaskId() == taskId);
    }

}
