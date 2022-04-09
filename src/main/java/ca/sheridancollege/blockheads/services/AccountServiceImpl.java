package ca.sheridancollege.blockheads.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.blockheads.domain.Account;
import ca.sheridancollege.blockheads.domain.RewardToken;
import ca.sheridancollege.blockheads.repository.AccountRepository;
import ca.sheridancollege.blockheads.repository.RewardTokenRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	private RewardTokenRepository rewardTokenRepository;


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
	
}
