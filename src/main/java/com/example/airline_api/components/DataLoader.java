package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // FLIGHTS

        Flight DEL = new Flight("Delhi",200,LocalDateTime.parse("2023-02-18T10:00:00"));
        flightRepository.save(DEL);

        Flight MIA = new Flight("Miami",250,LocalDateTime.parse("2023-02-19T06:00:00"));
        flightRepository.save(MIA);

        Flight LGW = new Flight("London",300,LocalDateTime.parse("2023-02-20T09:00:00"));
        flightRepository.save(DEL);

        Flight CUN = new Flight("Cancun",100,LocalDateTime.parse("2023-02-18T20:00:00"));
        flightRepository.save(CUN);

        Flight privateJet = new Flight("Secret", 1,LocalDateTime.parse("2023-02-23T13:00:00"));
        flightRepository.save(privateJet);

        // PASSENGERS

        Passenger hansine = new Passenger("Hansine", "hansine@bnta.co.uk");
        hansine.getFlights().add(DEL);
        passengerRepository.save(hansine);

        Passenger bob = new Passenger("Bob", "bob@bnta.co.uk");
        passengerRepository.save(bob);

        Passenger fred = new Passenger("Fred", "Fred@bnta.co.uk");
        passengerRepository.save(fred);

        Passenger annie = new Passenger("Annie", "annie@bnta.co.uk");
        annie.getFlights().add(MIA);
        passengerRepository.save(annie);

        Passenger carol = new Passenger("Carol", "carol@bnta.co.uk");
        passengerRepository.save(carol);

        Passenger dan = new Passenger("Dan", "dan@bnta.co.uk");
        dan.getFlights().add(CUN);
        passengerRepository.save(dan);

        Passenger eric = new Passenger("Eric", "eric@bnta.co.uk");
        passengerRepository.save(eric);

        Passenger gary = new Passenger("Gary", "gary@bnta.co.uk");
        passengerRepository.save(gary);

        Passenger izzy = new Passenger("Izzy", "izzy@bnta.co.uk");
        passengerRepository.save(izzy);

        Passenger jane = new Passenger("Jane", "jane@bnta.co.uk");
        jane.getFlights().add(privateJet);
        passengerRepository.save(jane);



    }
}
