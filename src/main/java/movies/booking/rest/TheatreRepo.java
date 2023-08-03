package movies.booking.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import movies.booking.entities.Theatre;

public interface TheatreRepo extends JpaRepository<Theatre, Integer> {

	@Query(" select t.name FROM Theatre t where t.movies.name = :name")
	List<String> getTheatreNames(@Param("name") String name);

	@Query("select id from Theatre where name=:name")
	int getTheatre(@Param("name") String name);
	
	Theatre findByName(String name);

}
