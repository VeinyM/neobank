package com.github.VeinyM.neobank.lessons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.github.VeinyM.neobank.lessons");

        Task task1 = context.getBean(Task.class);
        Task task2 = context.getBean(Task.class);
//        System.out.println(task1 == task2);

//        TaskManager taskManager = context.getBean(TaskManager.class);
//        System.out.println(taskManager);

        List<Task> list = List.of(task1,task2);

        TaskExecutor taskExecutor = context.getBean(TaskExecutor.class);
        taskExecutor.setTaskList(list);
        System.out.println(taskExecutor);
    }
}
