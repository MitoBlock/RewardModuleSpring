package ca.sheridancollege.blockheads.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AccountTokenDTO {
	Long accountId;
	Long tokenId;
}
