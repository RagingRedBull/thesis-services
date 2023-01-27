package dev.prmts.ui.backend.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Log4j2
public class ControllerAspect {

    @Pointcut("within(dev.prmts.ui.backend.controller..*)")
    public void controllerPointCut() {

    }

    @Around("controllerPointCut()")
    public Object methodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().toShortString();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object obj = proceedingJoinPoint.proceed();
        stopWatch.stop();
        log.info(String.format("Method %s took %s seconds to execute.", methodName, stopWatch.getTotalTimeSeconds()));
        return obj;
    }
}
