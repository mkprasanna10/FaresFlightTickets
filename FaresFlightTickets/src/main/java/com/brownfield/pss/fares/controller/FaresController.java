package com.brownfield.pss.fares.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brownfield.Logging.Loggable;
import com.brownfield.pss.fares.entity.Fare;
import com.brownfield.pss.fares.service.FaresService;

@RestController
@RequestMapping("/fares")
@CrossOrigin
public class FaresController 
{
	@Autowired
	FaresService fareservice;
	
	@GetMapping("/get")
	@Loggable
	public Fare findByFareByFlightNumberAndFlightDate(@RequestParam(value="flightNumber") String FlightNumber, 
			@RequestParam(value="flightDate") String FlightDate)
	{
		System.out.println(FlightNumber);
		System.out.println(FlightDate);
		return fareservice.findByFareByFlightNumberAndFlightDate(FlightNumber, FlightDate);
	}
	
}
