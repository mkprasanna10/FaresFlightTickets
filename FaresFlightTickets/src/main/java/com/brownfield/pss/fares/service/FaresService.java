package com.brownfield.pss.fares.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brownfield.Logging.Loggable;
import com.brownfield.pss.fares.entity.Fare;
import com.brownfield.pss.fares.repository.FaresRepository;


@Service
public class FaresService 
{
	public FaresService(){		
	}
	
	FaresRepository faresRepository;
	
	@Autowired
	public FaresService(FaresRepository faresRepository){
		this.faresRepository = faresRepository;
	}
			
	@Loggable
	public Fare findByFareByFlightNumberAndFlightDate(String FlightNumber, String FlightDate)
	{
		System.out.println(FlightNumber);
		System.out.println(FlightDate);
		System.out.println(faresRepository);
		
		Fare fare = faresRepository.getFareByFlightNumberAndFlightDate(FlightNumber, FlightDate);
		
		System.out.println(fare.toString());
		return fare;
	}
	
	@Loggable
	public void findByFareByFlightNumber(String FlightNumber)
	{
		List<Fare> fare = faresRepository.getFareByFlightNumber(FlightNumber);
		fare.stream().forEach(System.out::println);	
	}
	
	@Loggable
	public void findByFareByFlightDate(String FlightDate)
	{
		List<Fare> fare = faresRepository.getFareByFlightDate(FlightDate);
		fare.stream().forEach(System.out::println);	
	}
	
}
