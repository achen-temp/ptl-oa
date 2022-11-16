package com.ptl.exercise.Mindlance.simulator.angular.repositories;

import com.ptl.exercise.Mindlance.simulator.angular.models.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long> {
    //todo
    Candidate findByName(String name);
}
