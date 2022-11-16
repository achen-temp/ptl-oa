package com.ptl.exercise.Mindlance.simulator.angular.models;

public class CandidateSkills {
    CandidateSkillsId csk = new CandidateSkillsId();

    public Skills getSkills() {
        return getCsk().getSkills();
    }

    public void setSkills(Skills skills) {
        getCsk().setSkills(skills);
    }

    public Candidate getCandidate() {
        return getCsk().getCandidates();
    }

    public void setCandidate(Candidate candidate) {
        getCsk().setCandidates(candidate);
    }

    public CandidateSkillsId getCsk() {
        return csk;
    }

    public void setCsk(CandidateSkillsId csk) {
        this.csk = csk;
    }
}
