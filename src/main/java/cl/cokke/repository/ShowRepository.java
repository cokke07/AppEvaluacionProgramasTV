package cl.cokke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.cokke.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

	//@Query(value= "select * from show",nativeQuery = true)
	public List<Show> findAll();
}
