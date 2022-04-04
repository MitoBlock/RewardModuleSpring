package ca.sheridancollege.blockheads.services;

import java.util.List;

import ca.sheridancollege.blockheads.domain.RewardToken;

public interface RewardTokenService {
	
	public RewardToken findById(Long id);
	public List<RewardToken> findAll();
	public RewardToken save(RewardToken rewardToken);
}
