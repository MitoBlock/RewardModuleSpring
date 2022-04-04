package ca.sheridancollege.blockheads.services;

import java.util.List;

import ca.sheridancollege.blockheads.domain.User;


public interface UserService {
	
	public User findById(Long id);
	public User save(User user);
	public List<User> findAll();
}
