package ca.sheridancollege.blockheads.services;

import ca.sheridancollege.blockheads.domain.Reward;

public interface RewardService {
	
	public Reward findById(Long id);
	public Reward save(Reward reward);

}
