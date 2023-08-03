package movies.booking.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import movies.booking.entities.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

	@Query("select id From Movie where name=:name")
	int getMovie(@Param("name") String name);

	Movie findByName(String name);

}