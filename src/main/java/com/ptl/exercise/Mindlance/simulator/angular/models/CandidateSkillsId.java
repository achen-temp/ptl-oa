package com.ptl.exercise.Mindlance.simulator.angular.models;

import java.util.Objects;

//@Embeddable
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "")
public class CandidateSkillsId {
    public CandidateSkillsId() {
    }

    private static final long serialVersionUID = 1L;
    private Skills skills;
    private Candidate candidates;

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public Candidate getCandidates() {
        return candidates;
    }

    public void setCandidates(Candidate candidates) {
        this.candidates = candidates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkillsId that = (CandidateSkillsId) o;
        return skills.equals(that.skills) && candidates.equals(that.candidates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skills, candidates);
    }
}
