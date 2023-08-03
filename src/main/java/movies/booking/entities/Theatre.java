package movies.booking.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatre")
public class Theatre {
	@Id
	@Column(name = "theatre_id")
	private int id;
	@Column(name = "theatre_name")
	private String name;

	@Column(name = "movie_id")
	private int movie_id;
	@Column(name = "location")
	private String location;

	@Column(name = "capacity")
	private int capacity;

	@Column(name = "tickets_availability")
	private int tickets_availability;

	@Column(name = "ticket_price")
	private int price;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getTickets_availability() {
		return tickets_availability;
	}

	public void setTickets_availability(int tickets_availability) {
		this.tickets_availability = tickets_availability;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@OneToMany(mappedBy = "theatre")
	@JsonIgnore
	private List<TicketCounter> tickets;

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public List<TicketCounter> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketCounter> tickets) {
		this.tickets = tickets;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "movie_id", insertable = false, updatable = false)
	private Movie movies;

	public Movie getMovies() {
		return movies;
	}

	public void setMovies(Movie movies) {
		this.movies = movies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
