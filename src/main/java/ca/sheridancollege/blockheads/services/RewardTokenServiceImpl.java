package ca.sheridancollege.blockheads.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.blockheads.domain.RewardToken;
import ca.sheridancollege.blockheads.repository.RewardTokenRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RewardTokenServiceImpl implements RewardTokenService{
	
	private RewardTokenRepository rewardTokenRepository;

	@Override
	public RewardToken findById(Long id) {
		return rewardTokenRepository.findById(id).get();
	}

	@Override
	public RewardToken save(RewardToken rewardToken) {
		return rewardTokenRepository.save(rewardToken);	
	}

	@Override
	public List<RewardToken> findAll() {
		return rewardTokenRepository.findAll();
	}
}
