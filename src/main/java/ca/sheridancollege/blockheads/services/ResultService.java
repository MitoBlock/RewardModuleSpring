package ca.sheridancollege.blockheads.services;

import ca.sheridancollege.blockheads.domain.Result;

public interface ResultService {
	
	public Result findById(Long id);
	public Result save(Result result);

}
