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





    public Flight addPassengerToFlight(Long flightId, Long passengerId){
        Flight flightToUpdate = flightRepository.findById(flightId).get();
        Optional<Passenger> passenger = passengerService.getPassengerById(passengerId);
        List<Passenger> passengers = flightToUpdate.getPassengers();
        passengers.add(passenger.get());
        flightToUpdate.setPassengers(passengers);
        flightRepository.save(flightToUpdate);
        return flightToUpdate;
    }

    public void deleteFlight(long id){
        flightRepository.deleteById(id);
    }

    public List<Flight> findFlightsByDestination(String destination){
        return flightRepository.findByDestination(destination);
    }




}
