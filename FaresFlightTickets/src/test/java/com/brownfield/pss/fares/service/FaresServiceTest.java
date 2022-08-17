package com.brownfield.pss.fares.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.brownfield.pss.fares.entity.Fare;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FaresServiceTest 
{
	@Autowired
	FaresService fareservice;
	
	@AfterEach
	void cleanup()
	{
		System.out.println("Test classes are cleanup");
	}
	
	@Nested
	@EnabledOnOs(OS.WINDOWS)
	class FareFlightNumberFlightDate
	{
		@Test
		@DisplayName("findByFareByFlightNumberAndFlightDateTest")
		public void findByFareByFlightNumberAndFlightDatePositiveTest()
		{
			
			String FlightNumber = "BF101";
			String FlightDate = "22-JAN-16";
			Fare fare = fareservice.findByFareByFlightNumberAndFlightDate(FlightNumber, FlightDate);
			assertEquals(FlightNumber+":"+FlightDate, ((Fare) fare).getFlightNumber()+":"+((Fare) fare).getFlightDate(),
					() -> "Data should be Matched as Actual"+FlightNumber+":"+FlightDate+"Expected -->"+((Fare) fare).getFlightNumber()+":"+((Fare) fare).getFlightDate());
			System.out.println(fare.toString());
		}
	}
	
	@Nested
	@EnabledOnOs(OS.WINDOWS)
	class FareFlightNumber
	{
		@RepeatedTest(3)
		@DisplayName("Find by FlightNumber Positive")
		void FareFlightNumberPositiveTest(RepetitionInfo repitioninfo)
		{
			System.out.println(repitioninfo.getCurrentRepetition());
			String FlightNumber = "BF101";
			List<Fare> fare = fareservice.findByFareByFlightNumber(FlightNumber);
			assertEquals(FlightNumber, ((Fare) fare).getFlightNumber(),() -> "Data should be Matched as Actual"+FlightNumber+"Expected -->"+((Fare) fare).getFlightNumber());
		}
		
		@Test
		@DisplayName("Find by FlightNumber Negative")
		void FareFlightNumberNegativeTest()
		{
			String FlightNumber = null;
			assertThrows(NullPointerException.class, () -> fareservice.findByFareByFlightNumber(FlightNumber));
		}
	}
	
}
