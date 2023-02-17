package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String destination;
    @Column
    private int capacity;
    @Column
    private LocalDateTime departureDateTime;

//    @Column
//    private String departureDate;
//    @Column
//    private String departureTime;

    @JsonIgnoreProperties({"flights"})
    @ManyToMany
    @JoinTable(
            name = "passengers_flights",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private List<Passenger> passengers;

    public Flight(String destination, int capacity, LocalDateTime departureDateTime) {
        this.destination = destination;
        this.capacity = capacity;
        this.departureDateTime = departureDateTime;
        this.passengers = new ArrayList<>();
    }

    public Flight() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

//    public String getDepartureDate() {
//        return departureDate;
//    }
//
//    public void setDepartureDate(String departureDate) {
//        this.departureDate = departureDate;
//    }
//
//    public String getDepartureTime() {
//        return departureTime;
//    }
//
//    public void setDepartureTime(String departureTime) {
//        this.departureTime = departureTime;
//    }
}
