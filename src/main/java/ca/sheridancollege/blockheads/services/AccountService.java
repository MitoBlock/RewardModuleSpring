package ca.sheridancollege.blockheads.services;

import ca.sheridancollege.blockheads.domain.Account;

public interface AccountService {
	
	public Account findById(Long id);
	public Account save(Account account);

}
