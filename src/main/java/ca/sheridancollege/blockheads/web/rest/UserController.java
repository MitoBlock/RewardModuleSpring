package ca.sheridancollege.blockheads.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.blockheads.domain.User;
import ca.sheridancollege.blockheads.services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"", "/"})
	public User getUser(Long id) {
		return userService.findById(id);
	}
	
	@PostMapping(value = {"", "/"})
	public User save(@RequestBody User user) {
		return userService.save(user);
	}
	

}
