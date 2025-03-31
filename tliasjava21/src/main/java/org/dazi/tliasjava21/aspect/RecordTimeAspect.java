package org.dazi.tliasjava21.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Aspect
public class RecordTimeAspect {

  // 切入点表达式
  @Pointcut("execution(* org.dazi.tliasjava21.service.*.*(..))")
  public void pointcut() {}

  // 针对注解添加切入点表达式
  @Pointcut("@annotation(org.dazi.tliasjava21.anno.LogAnnotation)")
  public void pointcut2(JoinPoint joinPoint) {
    // 获取目标对象
    Object target = joinPoint.getTarget();

    // 获取目标类
    Class<?> targetClass = target.getClass();

    // 获取目标类的明细
    String className = targetClass.getName();

    // 获取目标方法
    String methodName = joinPoint.getSignature().getName();

    // 获取目标的参数
    Object[] args = joinPoint.getArgs();



  }

  @Around("pointcut()")
  public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long beginTime = System.currentTimeMillis();
    Object result = joinPoint.proceed();
    long endTime = System.currentTimeMillis();
    log.info("RecordTimeAspect {} recordTime: {}" , joinPoint.getSignature(), (endTime - beginTime));
    return result;
  }
}
