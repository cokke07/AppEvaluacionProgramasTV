package cl.cokke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.cokke.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

	public Rating findRatingById(Long id);
	public Rating findFirstByOrderByIdDesc();
	
	public List<Rating> findAllRatingByShowId(Long id);
	
	public List<Rating> findRatingByShowsId(Long id);
	
}
