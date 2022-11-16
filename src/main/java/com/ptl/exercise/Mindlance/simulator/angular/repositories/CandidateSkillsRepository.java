package com.ptl.exercise.Mindlance.simulator.angular.repositories;

import com.ptl.exercise.Mindlance.simulator.angular.models.CandidateSkills;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateSkillsRepository extends CrudRepository<CandidateSkills, Long> {
    //Iterator<CandidateSkills> findByCsk_Candidates(Candidate c);
}
