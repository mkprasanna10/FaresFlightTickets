package com.brownfield.Logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspectImpl
{
	@Around("@Annotation(com.brownfield.Logging.Loggable)")
	public Object myAroundRunMethod(ProceedingJoinPoint proceedingjoinpoint) throws Throwable
	{
		try
		{
			proceedingjoinpoint.proceed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return proceedingjoinpoint;
	}
	
}
