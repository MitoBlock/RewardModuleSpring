package ca.sheridancollege.blockheads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.blockheads.domain.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

}
