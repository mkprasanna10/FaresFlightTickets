package com.brownfield.pss.fares.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brownfield.pss.fares.entity.Fare;

@Repository 
public interface FaresRepository extends JpaRepository<Fare, Integer>
{	
	Fare getFareByFlightNumberAndFlightDate(String flightNumber, String flightDate);
	
	List<Fare> getFareByFlightNumber(String flightNumber);
	
	List<Fare> getFareByFlightDate(String flightNumber);
}
