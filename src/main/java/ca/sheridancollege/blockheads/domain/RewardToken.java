package ca.sheridancollege.blockheads.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RewardToken {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private LocalDateTime dateTime;
	
	@NonNull
	private String activityName;
	
	@NonNull
	private String activityCreator;
	
	@NonNull
	private String publicAddress;
	
	@OneToOne
	@JoinTable(name="REWARDTOKEN_RESULT", joinColumns = @JoinColumn(name="REWARDTOKEN_ID"), inverseJoinColumns=@JoinColumn(name="RESULT_ID"))
	private Result result;
	
	@OneToOne
	@JoinTable(name="REWARDTOKEN_REWARD", joinColumns = @JoinColumn(name="REWARDTOKEN_ID"), inverseJoinColumns=@JoinColumn(name="REWARD_ID"))
	private Reward reward;

}
