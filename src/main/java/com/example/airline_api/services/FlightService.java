package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;


    @Autowired
    PassengerService passengerService;



    public FlightService(){}

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id){
        return flightRepository.findById(id);
    }

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }





    public Flight addPassengerToFlight(Passenger passenger, Long id){
        Flight flightToUpdate = flightRepository.findById(id).get();
        flightToUpdate.addPassenger(passenger);
        return flightToUpdate;
    }




}
