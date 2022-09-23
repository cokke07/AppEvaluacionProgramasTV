package cl.cokke.service;

import java.util.List;
import java.util.Optional;

import cl.cokke.model.Show;


public interface ShowService{

	public Show findById(Long id);
	public List<Show> findAllShows();
	public void save(Show show);
	public void updateShow(Show show);
	public void deleteShow(Long id);
}
