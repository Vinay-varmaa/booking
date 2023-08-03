package movies.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import movies.booking.entities.Theatre;
import movies.booking.rest.TheatreRepo;

@RestController
public class TheatreController {
	@Autowired
	private TheatreRepo theatrerepo;

//2
	@GetMapping("/theatres")
	public List<Theatre> getTheatres() {
		return theatrerepo.findAll();
	}
//3
	@GetMapping("/theatrenames/{name}")
	public List<String> getTheatreNames(@PathVariable("name") String name) {
		return theatrerepo.getTheatreNames(name);
	}
//4 
	
}
