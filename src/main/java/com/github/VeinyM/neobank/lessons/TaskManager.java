package com.github.VeinyM.neobank.lessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskManager {

    private final Task task;

    @Autowired
    public TaskManager(Task task){
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task: #" + task.getName() + ", " + task.getDuration() + "sec.";
    }


}
