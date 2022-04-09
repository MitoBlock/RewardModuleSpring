package ca.sheridancollege.blockheads.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.blockheads.domain.Account;
import ca.sheridancollege.blockheads.domain.RewardToken;
import ca.sheridancollege.blockheads.entities.AccountTokenDTO;
import ca.sheridancollege.blockheads.repository.RewardTokenRepository;
import ca.sheridancollege.blockheads.services.AccountService;

@RestController
@CrossOrigin
@RequestMapping("/api/reward")
public class RewardTokenController {
	
	@Autowired
	private RewardTokenRepository rewardTokenRepository;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/rewardToken")
	public RewardToken save(@RequestBody RewardToken rewardToken) {
		return rewardTokenRepository.save(rewardToken);
	}

	@PostMapping("/addToken")
	public Account addToken(@RequestBody AccountTokenDTO accToken) {
		System.out.println();
		System.out.println("entering reward token endpoint in reward token controller");
		System.out.println(accToken);
		return accountService.addToken(accToken.getAccountId(),
				accToken.getTokenId());			

	}
}
