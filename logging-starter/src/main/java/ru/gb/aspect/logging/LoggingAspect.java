package ru.gb.aspect.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j // Slf4j - Simple logging facade for java
@Aspect
@RequiredArgsConstructor
public class LoggingAspect {

//  private final boolean printArgs = true;

  private final LoggingProperties properties;
  @Pointcut("@annotation(ru.gb.aspect.logging.Logging)") // method
  public void loggingMethodsPointcut() {}

  @Pointcut("@within(ru.gb.aspect.logging.Logging)") // class
  public void loggingTypePointcut() {}

  @Around(value = "loggingMethodsPointcut() || loggingTypePointcut()")
  public Object loggingMethod(ProceedingJoinPoint pjp) throws Throwable {
      if(properties.getPrintArgs()) {
          String methodName = pjp.getSignature().getName();
          log.info("Before -> TimesheetService#{}", methodName);
          try {
              return pjp.proceed();
          } finally {
              log.info("After -> TimesheetService#{}", methodName);
          }
      }
      return pjp.proceed();
  }

}
