package ca.sheridancollege.blockheads.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.blockheads.domain.Account;
import ca.sheridancollege.blockheads.domain.RewardToken;
import ca.sheridancollege.blockheads.entities.AccountTokenDTO;
import ca.sheridancollege.blockheads.repository.RewardTokenRepository;
import ca.sheridancollege.blockheads.services.AccountService;

@RestController
@CrossOrigin
@RequestMapping("/api/rewardToken")
public class RewardTokenController {
	
	@Autowired
	private RewardTokenRepository rewardTokenRepository;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public Account save(@RequestBody RewardToken rewardToken) {
		return accountService.saveRewardToken(rewardToken);
	}
	@PutMapping
	public Account delete(@RequestBody RewardToken rewardToken) {
		return accountService.deleteRewardToken(rewardToken);
	}
	@PutMapping("/{id}")
	public Account reducePoints(@PathVariable Long id) {
		return accountService.reducePoints(id);
	}

}
