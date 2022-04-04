package ca.sheridancollege.blockheads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.blockheads.domain.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {

}
