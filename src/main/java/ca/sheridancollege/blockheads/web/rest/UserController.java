package ca.sheridancollege.blockheads.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.blockheads.domain.User;
import ca.sheridancollege.blockheads.services.UserService;


@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"{id}", "/{id}"})
	public User getUser(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@PostMapping(value = {"", "/"})
	public User save(@RequestBody User user) {
		return userService.save(user);
	}
	

}
