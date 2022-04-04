package ca.sheridancollege.blockheads.services;

import org.springframework.stereotype.Service;

import ca.sheridancollege.blockheads.domain.Reward;
import ca.sheridancollege.blockheads.repository.RewardRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RewardServiceImpl implements RewardService {
	
	private RewardRepository rewardRepository;

	@Override
	public Reward findById(Long id) {
		return rewardRepository.findById(id).get();
	}

	@Override
	public Reward save(Reward reward) {
		return rewardRepository.save(reward);
	}

}
