package ca.sheridancollege.blockheads.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.Token;
import ca.sheridancollege.blockheads.domain.Account;
import ca.sheridancollege.blockheads.domain.Result;
import ca.sheridancollege.blockheads.domain.Reward;
import ca.sheridancollege.blockheads.domain.RewardToken;
import ca.sheridancollege.blockheads.repository.AccountRepository;
import ca.sheridancollege.blockheads.repository.ResultRepository;
import ca.sheridancollege.blockheads.repository.RewardRepository;
import ca.sheridancollege.blockheads.repository.RewardTokenRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	private RewardTokenRepository rewardTokenRepository;
	private ResultRepository resultRepository;
	private RewardRepository rewardRepository;


	@Override
	public Account findById(Long id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}
	
	@Override
	public Account addToken(Long accId, Long tokenId) {
		Account account = accountRepository.findById(accId).get();
		RewardToken rewardToken = rewardTokenRepository.findById(tokenId).get();
		System.out.println("about to save token into account with following: ");
		System.out.println(accId);
		System.out.println(tokenId);
		account.getRewardTokens().add(rewardToken);
		System.out.println("saving following account in account service: ");
		System.out.println(account);
		return accountRepository.save(account);

	}

	@Override
	public Account saveRewardToken(RewardToken rewardToken) {
		LocalDateTime timeInFiveDays = LocalDateTime.now().plusDays(5);
		Account account = accountRepository.findByPublicAddress(rewardToken.getPublicAddress());
		rewardToken.setDateTime(LocalDateTime.now());

		Reward reward = rewardToken.getReward();
		reward.setExpiryDate(timeInFiveDays);
		Result result = rewardToken.getResult();
		
		Reward savedReward = rewardRepository.save(reward);
		Result savedResult = resultRepository.save(result);
		rewardToken.setReward(savedReward);
		rewardToken.setResult(savedResult);
		RewardToken savedRewardToken = rewardTokenRepository.save(rewardToken);
		account.getRewardTokens().add(savedRewardToken);
		return accountRepository.save(account);

	}

	@Override
	public Account deleteRewardToken(RewardToken rewardToken) {
		Account account = accountRepository.findByPublicAddress(rewardToken.getPublicAddress());
		List<RewardToken> rewardTokens = account.getRewardTokens();
		rewardTokens.removeIf(t -> t.getId() == rewardToken.getId());
		return accountRepository.save(account);

	}

	// this method assumes there is at least 6 'points' in the reward
	@Override
	public Account reducePoints(Long rewardTokenId) {
		RewardToken rewardToken = rewardTokenRepository.findById(rewardTokenId).get();
		
		Reward reward = rewardToken.getReward();
		int currValue = reward.getValue();
		if (currValue <= 5) System.out.println("oops, something went wrong");
		reward.setValue(currValue - 5);
		rewardRepository.save(reward);
		return accountRepository
				.findByPublicAddress(rewardToken.getPublicAddress());
		
	}
	
}
