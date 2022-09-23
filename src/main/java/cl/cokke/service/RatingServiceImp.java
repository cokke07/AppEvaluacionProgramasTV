package cl.cokke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cokke.model.Rating;
import cl.cokke.repository.RatingRepository;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public List<Rating> findAllRatings() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public Rating findRatingById(Long id) {
		// TODO Auto-generated method stub
		return ratingRepository.findRatingById(id);
	}

	@Override
	public void addRating(Rating rating) {
		ratingRepository.save(rating);		
	}

	@Override
	public Rating findFirstByOrderByIdDesc() {
		// TODO Auto-generated method stub
		return ratingRepository.findFirstByOrderByIdDesc();
	}

	@Override
	public List<Rating> findAllRatingByShowId(Long id) {
		// TODO Auto-generated method stub
		return ratingRepository.findAllRatingByShowId(id);
	}

	@Override
	public List<Rating> findRatingByShowsId(Long id) {
		// TODO Auto-generated method stub
		return ratingRepository.findRatingByShowsId(id);
	}



}
