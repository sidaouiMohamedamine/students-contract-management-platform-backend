package com.sidaoui.projetSpring.Config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

        @Before("execution(* com.sidaoui.projetSpring.Service.*.get*(..))")
        public void logMethodEntry(JoinPoint joinPoint){
            String name = joinPoint.getSignature().getName();
            log.info("Début Execution : " + name + " : ");
        }



}
