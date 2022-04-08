package ca.sheridancollege.blockheads.bootstrap;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;

import ca.sheridancollege.blockheads.domain.Result;
import ca.sheridancollege.blockheads.domain.Reward;
import ca.sheridancollege.blockheads.domain.RewardToken;
import ca.sheridancollege.blockheads.repository.RewardTokenRepository;
import ca.sheridancollege.blockheads.services.ResultService;
import ca.sheridancollege.blockheads.services.RewardService;
import ca.sheridancollege.blockheads.services.RewardTokenService;
import lombok.AllArgsConstructor;

//@AllArgsConstructor
@Component
public class PostBootstrap implements CommandLineRunner {

	@Autowired
	private RewardService rewardService;

	@Autowired
	private ResultService resultService;

	@Autowired
	private RewardTokenService rewardTokenService;

	@Override
	public void run(String... args) throws Exception {
		
		RewardToken token = new RewardToken();
		String originalString = "someToken";
		String hashed = Hashing.sha256()
				  .hashString(originalString, StandardCharsets.UTF_8)
				  .toString();
		token.setPublicAddress(hashed);
		token.setActivityName("First time using app");
		token.setDateTime(LocalDateTime.now());
		token.setActivityCreator("Testman");
		Result result = new Result();
		result.setMessage("Congrats!");
		result.setScore(7);
		Reward reward = new Reward();
		LocalDateTime futureDateTime = LocalDateTime.of(2023,
				Month.JULY, 29, 19, 30, 40);
		reward.setExpiryDate(futureDateTime);
		reward.setTargetPartner("FooBazz");
		reward.setType("Coupon");
		reward.setValue(10);
		
		Reward savedReward = rewardService.save(reward);
		Result savedResult = resultService.save(result);
		
		token.setResult(savedResult);
		token.setReward(savedReward);
		
		RewardToken savedToken = rewardTokenService.save(token);
		
		System.out.println(savedToken);

	}
}
