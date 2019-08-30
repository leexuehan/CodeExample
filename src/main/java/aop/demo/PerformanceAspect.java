package aop.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.logging.Logger;

/**
 * @author leexuehan on 2019/8/30.
 */
@Aspect
public class PerformanceAspect {
    @Pointcut("execution(public String Foo.doSomething(String))")
    private void method1Exec() {
        System.out.println("logic in pointcut");
    }

    @AfterReturning(pointcut = "method1Exec()", returning = "retValue")
    public void taskCompleted(JoinPoint joinPoint, String retValue) {
        System.out.println("return value:" + retValue);
    }

    @Before("method1Exec()")
    public void beforeAdvice(JoinPoint point) {
        System.out.println("before advice in foo.Param:" + point.getArgs()[0]);
    }


    @Around("method1Exec()")
    public String trace(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before process");
        try {
            return (String) joinPoint.proceed();
        } finally {
            System.out.println("after process");
        }
    }
}
