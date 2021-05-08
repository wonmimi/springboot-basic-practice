package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component // 빈 등록 방법 중 1
public class TimeTraceAOP {

    // 타겟팅
    @Around("execution(* hello.hellospring..*(..))")
    // = hello.hellospring 하위 클래스 모두 적용
//    @Around("execution(* hello.hellospring.service..*(..))") // service 하위만
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START" + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END" + joinPoint.toString() + " " + timeMs + "ms");

        }
    }
}
