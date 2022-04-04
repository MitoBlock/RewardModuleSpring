package ca.sheridancollege.blockheads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.blockheads.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
