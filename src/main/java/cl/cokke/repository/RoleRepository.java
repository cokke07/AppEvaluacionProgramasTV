package cl.cokke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.cokke.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public List<Role> findAll();
	public List <Role> findByName(String name);
	
}
