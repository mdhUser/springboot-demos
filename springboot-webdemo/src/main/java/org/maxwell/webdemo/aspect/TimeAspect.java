package org.maxwell.webdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/2 16:16
 */
@Aspect
@Component
public class TimeAspect {

    @Pointcut("execution(* org.maxwell.webdemo.service.impl.*.find*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object timing(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.printf("%s查询用时===%dms\n", pjp.getSignature().getName(), end - start);
        return result;
    }


}
