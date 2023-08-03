package movies.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import movies.booking.entities.Movie;
import movies.booking.rest.MovieRepo;

@RestController
public class MovieController {

	@Autowired
	private MovieRepo movierepo;

	// 1movienames
	@GetMapping("/movienames")
	public List<Movie> getmovies() {
		return movierepo.findAll();
	}

}
