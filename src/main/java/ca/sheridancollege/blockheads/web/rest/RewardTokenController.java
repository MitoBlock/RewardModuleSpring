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
		System.out.println(" spring received the following token from ang");
		System.out.println(rewardToken);
		return accountService.saveRewardToken(rewardToken);
	}
	@PutMapping
	public Account delete(@RequestBody RewardToken rewardToken) {
		System.out.println("received the following in put mapping...");
		System.out.println(rewardToken);
		return accountService.deleteRewardToken(rewardToken);
	}


	/*
	@PostMapping("/{id}")
	public Account addToken(@PathVariable String id,
			@RequestBody AccountTokenDTO accToken) {
		System.out.println("id is " + id);
		System.out.println("entering reward token endpoint in reward token controller");
		System.out.println(accToken);
		return accountService.addToken(accToken.getAccountId(),
				accToken.getTokenId());			

	}
	*/
}
