package movies.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import movies.booking.entities.Theatre;
import movies.booking.entities.TicketCounter;
import movies.booking.rest.MovieRepo;
import movies.booking.rest.TheatreRepo;
import movies.booking.rest.TicketRepo;

@RestController
public class TicketController {

	@Autowired
	private TicketRepo ticketrepo;

	@Autowired
	private TheatreRepo trepo;

	@Autowired
	private MovieRepo mrepo;

	@GetMapping("/tickets")
	private List<TicketCounter> getTickets() {
		return ticketrepo.findAll();
	}

//	int capacity = 2;

//	@PostMapping("/ticketsbooking")
//	public String addTicket(@RequestBody Theatre tickets) {
//
//		try {
//			if (capacity > 1) {
//				capacity--;
//				return "ticket booked sucessfully";
//
//			} else {
//				return "housefull";
//			}
//
//		} catch (Exception ex) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PAYMENT FAILED!");
//		}
//	}
	@PostMapping("/ticketbooking/{no}")
	public TicketCounter addticket(@PathVariable("no") int no, @RequestParam("movie_name") String movie_name,
			@RequestParam("theatre_name") String theatre_name, @RequestParam("show") String show) {
		int obj = mrepo.getMovie(movie_name);
		var obj1 = trepo.getTheatre(theatre_name);
		Theatre t = trepo.findById(obj1).get();
		int price = 0;
		TicketCounter tc = new TicketCounter();
		tc.setMovie_id(obj);
		tc.setTheatre_id(obj1);
		tc.setShow(show);

		if (t.getTickets_availability() == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "HOUSEFULL");
		}
		int num = t.getTickets_availability() - no;
		if (t.getTickets_availability() < no)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Available tickets are " + t.getTickets_availability());
		t.setTickets_availability(num);
		trepo.save(t);
		price = no * t.getPrice();

		tc.setCollection(price);
		// ===================================
		ticketrepo.save(tc);

		// ------------------------------------

		return tc;
	}
}
