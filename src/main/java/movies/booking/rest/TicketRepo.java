package movies.booking.rest;

import org.springframework.data.jpa.repository.JpaRepository;

import movies.booking.entities.TicketCounter;

public interface TicketRepo extends JpaRepository<TicketCounter, Integer> {

	//TicketCounter getIdByTheatreId(int id);
	
	TicketCounter getIdByTheatreId(int id);
}
