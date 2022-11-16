package com.ptl.exercise.Mindlance.simulator.angular.models;

import java.util.List;

public class Candidate {

    long id;
    String name;
    String address;
    String city;
    String phone;
    String email;

    List<CandidateSkills> candidateSkills;

    public List<CandidateSkills> getCandidateSkills() {
        return candidateSkills;
    }

    public void setCandidateSkills(List<CandidateSkills> candidateSkills) {
        this.candidateSkills = candidateSkills;
    }

    public Candidate() {
    }

    public Candidate(String name, String address, String city, String phone, String email) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
