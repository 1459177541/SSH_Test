package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class LoggerAop {

    private static Logger LOGGER = LoggerFactory.getLogger(LoggerAop.class);

    @Pointcut("execution(* service.*+.*(..))")
    public void logger(){}

    @After("logger()")
    public void after(JoinPoint joinPoint) throws NoSuchMethodException {
        Class<?> c = joinPoint.getTarget().getClass();
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = c.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        LOGGER.info("{} {}.{}({})执行",
                method.getReturnType(),
                c.getName(),
                method.getName(),
                joinPoint.getArgs());
//        Stream.of(Thread.currentThread().getStackTrace()).forEach(System.err::println);
    }

    @AfterThrowing("logger()")
    public void throwing(JoinPoint joinPoint) throws NoSuchMethodException {
        Class<?> c = joinPoint.getTarget().getClass();
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = c.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        LOGGER.info("{} {}.{}({})出错",
                method.getReturnType(),
                c.getName(),
                method.getName(),
                joinPoint.getArgs());
    }

}
