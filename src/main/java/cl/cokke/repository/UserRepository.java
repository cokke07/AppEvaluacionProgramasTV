package cl.cokke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.cokke.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findAll();
	public User findByUsername(String username);
	public User findUserByEmail(String email);
	
}
