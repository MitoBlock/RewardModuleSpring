package ca.sheridancollege.blockheads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.blockheads.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
