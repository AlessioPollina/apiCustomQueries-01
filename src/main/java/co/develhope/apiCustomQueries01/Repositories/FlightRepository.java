package co.develhope.apiCustomQueries01.Repositories;

import co.develhope.apiCustomQueries01.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
