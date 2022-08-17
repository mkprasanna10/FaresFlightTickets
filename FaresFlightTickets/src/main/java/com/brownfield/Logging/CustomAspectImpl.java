package com.brownfield.Logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.brownfield.pss.fares.entity.Fare;

@Aspect
@Component
public class CustomAspectImpl
{
	
	@Before(value = "execution(public Fare findByFareByFlightNumberAndFlightDate(..))")
	public void beforeAdvice(JoinPoint joinPoint, String FlightNumber, String FlightDate) {
		System.out.println("Before method:" + joinPoint.getSignature());

		System.out.println("Creating findByFareByFlightNumberAndFlightDate with FlightNumber - " + FlightNumber + " and FlightDate - " + FlightDate);
	}

	
	/*@Around("@annotation(com.brownfield.Logging.Loggable)")
	public Object myAroundRunMethod(ProceedingJoinPoint proceedingjoinpoint) throws Throwable
	{
		Object proceed = null;
		try
		{
			long start = System.currentTimeMillis();
		    proceed = proceedingjoinpoint.proceed();
		    long executionTime = System.currentTimeMillis() - start;
		    System.out.println(proceedingjoinpoint.getSignature() + " executed in " + executionTime + "ms");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return proceed;
	}*/
	
}
