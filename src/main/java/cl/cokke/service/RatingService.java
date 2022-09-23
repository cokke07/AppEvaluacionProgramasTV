package cl.cokke.service;

import java.util.List;

import cl.cokke.model.Rating;

public interface RatingService {

	public List<Rating> findAllRatings();
	public Rating findRatingById(Long id);
	public void addRating(Rating rating);
	public Rating findFirstByOrderByIdDesc();
	public List<Rating> findAllRatingByShowId(Long id);
	public List<Rating> findRatingByShowsId(Long id);
	
}
