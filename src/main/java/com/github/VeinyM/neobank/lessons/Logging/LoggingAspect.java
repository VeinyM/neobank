package com.github.VeinyM.neobank.lessons.Logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("@annotation(loggable)")
    public void log(JoinPoint joinPoint, Loggable loggable){
        for (int i = 0; i < loggable.times(); i++) {
            System.out.printf("LOG %s: before method=%s \n",
                    loggable.type(),
                    joinPoint.getSignature().getName());
        }
    }
}
