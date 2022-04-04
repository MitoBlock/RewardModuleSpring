package ca.sheridancollege.blockheads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.blockheads.domain.Reward;

public interface RewardRepository extends JpaRepository<Reward, Long> {

}
