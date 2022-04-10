package ca.sheridancollege.blockheads.services;

import ca.sheridancollege.blockheads.domain.Account;
import ca.sheridancollege.blockheads.domain.RewardToken;

public interface AccountService {
	
	public Account findById(Long id);
	public Account save(Account account);
	public Account addToken(Long accId, Long tokenId);
	public Account saveRewardToken(RewardToken rewardToken);
	public Account deleteRewardToken(RewardToken rewardToken);
	public Account reducePoints(Long id);

}
