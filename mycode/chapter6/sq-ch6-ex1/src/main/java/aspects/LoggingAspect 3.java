package aspects;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("execution(* services.*.*(..))")
    public void log() {
    }
}
