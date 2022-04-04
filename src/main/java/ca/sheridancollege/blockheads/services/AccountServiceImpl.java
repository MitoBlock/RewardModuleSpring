package ca.sheridancollege.blockheads.services;

import org.springframework.stereotype.Service;

import ca.sheridancollege.blockheads.domain.Account;
import ca.sheridancollege.blockheads.repository.AccountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;

	@Override
	public Account findById(Long id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

}
