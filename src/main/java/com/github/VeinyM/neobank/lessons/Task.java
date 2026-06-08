package com.github.VeinyM.neobank.lessons;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class Task {
    private Random random = new Random();
    private String name;
    private Long duration;


    public Task(){
        this.name = onlyDigits(this.toString()) /*this.toString()*/;
        this.duration = random.nextLong(30L,120L);
//        System.out.println("Task: #" + name + " created.");
    }



    private String onlyDigits(String str){
        StringBuilder ans = new StringBuilder();
        int index = str.length()-1;
        for (char ch = str.charAt(index); ch!='@'; index-=1, ch=str.charAt(index)){
            ans.append(ch);
        }
        return ans.reverse().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
