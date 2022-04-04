package ca.sheridancollege.blockheads.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Reward {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String type;
	
	@NonNull
	private Integer value;
	
	@NonNull
	private String targetPartner;
	
	@NonNull
	private LocalDateTime expiryDate;

}
