package link.hiroshisprojects.hibernate.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

	private final static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	private void springFrameworkPointcut() {}


	@Pointcut("within(link.hiroshisprojects.hibernate.models..*)")
	private void applicationPackagePointcut(){}

	@AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		LOGGER.error("AOP LOGGER: Exception in {}.{}()\n", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e);
	}

	@Around("applicationPackagePointcut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("ENTER: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		}
        try {
            Object result = joinPoint.proceed();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("EXIT: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), result);
            }
            return result;
        } catch (IllegalArgumentException e) {
            LOGGER.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            throw e;
        }
	}	
}
