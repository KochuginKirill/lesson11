package ru.gb.aspect.recovery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j // Slf4j - Simple logging facade for java
@Aspect
@RequiredArgsConstructor
public class RecoveryAspect {
    private final RecoveryProperties properties;
    @Pointcut("@annotation(ru.gb.aspect.logging.Logging)") // method
    public void loggingMethodsPointcut() {}

    @Pointcut("@within(ru.gb.aspect.logging.Logging)") // class
    public void loggingTypePointcut() {}

    @Around(value = "loggingMethodsPointcut() || loggingTypePointcut()")
    public Object loggingMethod(ProceedingJoinPoint pjp) throws Throwable {
        if(properties.isEnabled()) {
            log.info("Работает!");
        }
        return pjp.proceed();
    }

}
