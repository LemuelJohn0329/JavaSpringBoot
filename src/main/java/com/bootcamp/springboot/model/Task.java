package com.bootcamp.springboot.model;

public class Task {

    private long taskId;
    private String description;
    private String date;

    public Task(){}

    public Task(long taskId, String description, String date) {
        this.taskId = taskId;
        this.description = description;
        this.date = date;
    }

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
}
