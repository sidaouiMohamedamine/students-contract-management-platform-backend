package com.sidaoui.projetSpring.Config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @AfterReturning("execution(* com.sidaoui.projetSpring.Service.*.*(..))")
    public void logMethodExit1(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method without errors : " + name );
    }
    @AfterThrowing("execution(* com.sidaoui.projetSpring.Service.*.*(..))")
    public void logMethodExit2(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.error("Out of method with erros : " + name );
    }
    @After("execution(* com.sidaoui.projetSpring.Service.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method (in all cases) : " + name );
    }

    @Around("execution(* com.sidaoui.projetSpring.Service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }

}
