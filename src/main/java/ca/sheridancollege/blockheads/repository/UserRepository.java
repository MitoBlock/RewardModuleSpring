package ca.sheridancollege.blockheads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.blockheads.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
