package com.github.VeinyM.neobank.lessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component

public class TaskExecutor {
    private List<Task> taskList;

    @Autowired
    public TaskExecutor() {
//        this.taskList = taskList;
        System.out.println("Executor concha");
    }

    @Override
    public String toString(){
        String ans = "";
        for (Task task : taskList) {
            ans += "Task:" + task.getName() + " duration: " + task.getDuration() + "\n";
        };

        return ans;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
