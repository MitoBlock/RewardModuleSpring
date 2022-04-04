package ca.sheridancollege.blockheads.services;

import org.springframework.stereotype.Service;

import ca.sheridancollege.blockheads.domain.Result;
import ca.sheridancollege.blockheads.repository.ResultRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ResultServiceImpl implements ResultService {
	
	private ResultRepository resultRepository;

	@Override
	public Result findById(Long id) {
		return resultRepository.findById(id).get();
	}

	@Override
	public Result save(Result result) {
		return resultRepository.save(result);
	}

}
