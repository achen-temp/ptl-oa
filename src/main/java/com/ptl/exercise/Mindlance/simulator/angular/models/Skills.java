package com.ptl.exercise.Mindlance.simulator.angular.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Set;

//@Entity
//@Table(name = "skills")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "")
public class Skills implements Serializable {

    public static final long servialVersionUID = 1L;

    public Skills() {
    }

    long id;
    String name;
    String description;
    Set<CandidateSkills> candidateskills;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CandidateSkills> getCandidateskills() {
        return candidateskills;
    }

    public void setCandidateskills(Set<CandidateSkills> candidateskills) {
        this.candidateskills = candidateskills;
    }
}
