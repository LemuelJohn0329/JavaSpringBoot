package com.bootcamp.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    private long taskId;
    private String description;
    private String date;
    private boolean isTaskIdExist;

    public Task(){}

    public Task(long taskId, String description, String date) {
        this.taskId = taskId;
        this.description = description;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isTaskIdExist() {
        return isTaskIdExist;
    }

    public void setTaskIdExist(boolean taskIdExist) {
        isTaskIdExist = taskIdExist;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
