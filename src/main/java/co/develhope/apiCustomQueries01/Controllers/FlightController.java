package co.develhope.apiCustomQueries01.Controllers;

import co.develhope.apiCustomQueries01.Entities.Flight;
import co.develhope.apiCustomQueries01.Entities.FlightStatus;
import co.develhope.apiCustomQueries01.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @PostMapping("")
    public List<Flight> flightsSupply(){
        List<Flight> flightsList = new ArrayList<>();
        Random generateFlights = new Random();
        for (int i = 0; i<50; i++){
            Flight flight = new Flight();
            flight.setDescription("Flight " + i);
            flight.setFromAirport("Airport " + generateFlights.nextInt(10));
            flight.setToAirport("Airport " + generateFlights.nextInt(10));
            flight.setStatus(FlightStatus.ONTIME);
            flightsList.add(flightRepository.save(flight));
        }
        return flightsList;

        }
    }

