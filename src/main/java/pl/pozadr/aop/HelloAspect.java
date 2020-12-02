package pl.pozadr.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    @Around("execution(String pl.pozadr.aop.Hello.sayHello())")
    // without ProceedingJoinPoint method call instead execution method
    //
    private void beforeHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Hello!");
        joinPoint.proceed();
    }

    @Before("execution(String pl.pozadr.aop.Hello.sayHello())")
    private void beforeHello() {
        System.out.println("Before Hello!");
    }

    @After("execution(String pl.pozadr.aop.Hello.sayHello())")
    private void afterHello() {
        System.out.println("After Hello!");
    }

}
