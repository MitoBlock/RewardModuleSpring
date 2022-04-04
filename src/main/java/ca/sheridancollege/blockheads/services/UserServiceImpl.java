package ca.sheridancollege.blockheads.services;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.blockheads.domain.Account;
import ca.sheridancollege.blockheads.domain.User;
import ca.sheridancollege.blockheads.repository.AccountRepository;
import ca.sheridancollege.blockheads.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	private AccountRepository accountRepository;

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User save(User user) {
		//Make new account for this user
		Account a = new Account();
		a.setPublicAddress(generateAddress());
		accountRepository.save(a);
		user.setAccount(a);
		
		return userRepository.save(user);	
	}
	
	//Helper function to generate address
	private String generateAddress() {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789".toCharArray();
		
		SecureRandom random = new SecureRandom();
		StringBuilder address = new StringBuilder();
		
		int length = 20;
		
		for (int i = 0; i < length; i++) {
			address.append(chars[random.nextInt(chars.length)]);
	    }
		
		return address.toString();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
