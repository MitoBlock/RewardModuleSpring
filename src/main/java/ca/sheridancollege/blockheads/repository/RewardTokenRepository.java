package ca.sheridancollege.blockheads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.blockheads.domain.RewardToken;

@Repository
public interface RewardTokenRepository extends JpaRepository<RewardToken, Long> {

}
