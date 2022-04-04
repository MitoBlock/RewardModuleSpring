package ca.sheridancollege.blockheads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.blockheads.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
