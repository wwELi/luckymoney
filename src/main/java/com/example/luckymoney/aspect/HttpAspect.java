package com.example.luckymoney.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.luckymoney.controller.*.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void log (JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.info("------ this before url-------- " + request.getRequestURI() + joinPoint.getSignature().toString());
    }

    @After("pointCut()")
    public void afterLog () {
        logger.info("------ this after-------- ");
    }

//    @AfterReturning(pointcut = "pointCut()", returning = "obj")
//    public void after(Object obj) {}
}
