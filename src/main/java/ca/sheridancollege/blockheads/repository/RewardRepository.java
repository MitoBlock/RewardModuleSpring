package ca.sheridancollege.blockheads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.blockheads.domain.Reward;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {

}
