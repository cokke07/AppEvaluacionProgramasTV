package cl.cokke.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cokke.model.Show;
import cl.cokke.repository.ShowRepository;

@Service
public class ShowServiceImp implements ShowService {

	@Autowired
	private ShowRepository showRepository;

	@Override
	public Show findById(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		if (optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Show> findAllShows() {
		// TODO Auto-generated method stub
		return showRepository.findAll();
	}

	@Override
	public void save(Show show) {
		showRepository.save(show);
		
	}

	@Override
	public void updateShow(Show show) {
		showRepository.save(show);
		
	}

	@Override
	public void deleteShow(Long id) {
		showRepository.deleteById(id);
		
	}
	
	

}
