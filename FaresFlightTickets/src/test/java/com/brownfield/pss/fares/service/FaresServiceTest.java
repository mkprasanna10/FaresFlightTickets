package com.brownfield.pss.fares.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.brownfield.pss.fares.entity.Fare;

class FaresServiceTest 
{
	FaresService fareservice = new FaresService();

	@Test
	@DisplayName("findByFareByFlightNumberAndFlightDateTest")
	public void findByFareByFlightNumberAndFlightDateTest()
	{
		String FlightNumber = "BF101";
		String FlightDate = "22-JAN-16";
		Fare fare = fareservice.findByFareByFlightNumberAndFlightDate(FlightNumber, FlightDate);
		System.out.println(fare.toString());
	}
	
}
