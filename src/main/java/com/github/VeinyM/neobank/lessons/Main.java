package com.github.VeinyM.neobank.lessons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@Configuration
// Сканируем корневой пакет lessons. Spring автоматически зайдет во все
// подпакеты, включая lessons.Logging (или lessons.aop) и найдет там твой Аспект!
@ComponentScan("com.github.VeinyM.neobank.lessons")
@EnableAspectJAutoProxy // Включаем АОП
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        Task task1 = context.getBean(Task.class);
        Task task2 = context.getBean(Task.class);
//        System.out.println(task1 == task2);

        TaskManager taskManager = context.getBean(TaskManager.class);
        taskManager.printTask();
//        System.out.println(taskManager);

        List<Task> list = List.of(task1,task2);
//
        TaskExecutor taskExecutor = context.getBean(TaskExecutor.class);
        taskExecutor.setTaskList(list);
        taskExecutor.printExecutor();
//        System.out.println(taskExecutor);


    }
}
