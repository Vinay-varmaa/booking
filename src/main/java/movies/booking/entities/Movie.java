package movies.booking.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@Column(name = "movie_id")
	private int id;

	@Column(name = "movie_name")
	private String name;

	@Column(name = "genre")
	private String genre;

	@Column(name = "duration")
	private String duration;

	@OneToMany(mappedBy = "movies")
	@JsonIgnore
	private List<Theatre> theatre;

	@OneToMany(mappedBy = "movie")
	@JsonIgnore
	private List<TicketCounter> tickets;

	public List<Theatre> getTheatre() {
		return theatre;
	}

	public void setTheatre(List<Theatre> theatre) {
		this.theatre = theatre;
	}

	public List<TicketCounter> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketCounter> tickets) {
		this.tickets = tickets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	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
}
