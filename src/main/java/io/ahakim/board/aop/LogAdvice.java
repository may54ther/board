package io.ahakim.board.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAdvice {

    @Around("execution(* io.ahakim.board.controller..*Controller.*(..))"
            + " || execution(* io.ahakim.board.service..*Service.*(..))")
    public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        log.info(type + "." + proceedingJoinPoint.getSignature().getName() + "() <=================");
        log.info("Argument/Parameter : " + Arrays.toString(proceedingJoinPoint.getArgs()));
        log.info("=================>");
        return proceedingJoinPoint.proceed();
    }
}



