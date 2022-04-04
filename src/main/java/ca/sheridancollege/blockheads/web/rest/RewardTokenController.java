package ca.sheridancollege.blockheads.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.blockheads.domain.RewardToken;
import ca.sheridancollege.blockheads.repository.RewardTokenRepository;

@RestController
@RequestMapping("/api/reward")
public class RewardTokenController {
	
	@Autowired
	private RewardTokenRepository rewardTokenRepository;
	
	@PostMapping("/rewardToken")
	public RewardToken save(@RequestBody RewardToken rewardToken) {
		return rewardTokenRepository.save(rewardToken);
	}
}
