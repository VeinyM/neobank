package com.github.VeinyM.neobank.lessons;

import com.github.VeinyM.neobank.lessons.Logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskManager {
    private final Task task;

    @Autowired
    public TaskManager(Task task){
        this.task = task;
//        System.out.println("Task Manager started: ");

    }

    @Override
    public String toString() {
        return "Task: #" + task.getName() + ", " + task.getDuration() + "sec.";
    }

    @Loggable(type = "TaskManagerINFO")
    public void printTask(){
//        System.out.println("Task: #" + task.getName() + ", " + task.getDuration() + "sec.");
    }

}
