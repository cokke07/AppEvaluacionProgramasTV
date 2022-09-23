package cl.cokke.service;

import java.util.List;

import cl.cokke.model.User;

public interface UserService {

	public List<User> findAllUsers();
	public User findByUsername(String username);
	public User findUserByEmail(String email);
	public User findUserById(Long id);
	
	public void saveWithUserRole(User user);
	public void saveUserWithAdminRole(User user);
	
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long id);
}
