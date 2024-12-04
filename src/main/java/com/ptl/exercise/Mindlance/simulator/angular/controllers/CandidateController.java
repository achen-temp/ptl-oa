package com.ptl.exercise.Mindlance.simulator.angular.controllers;

import com.ptl.exercise.Mindlance.simulator.angular.dto.CandidateDTO;
import com.ptl.exercise.Mindlance.simulator.angular.dto.SkillsDTO;
import com.ptl.exercise.Mindlance.simulator.angular.models.Candidate;
import com.ptl.exercise.Mindlance.simulator.angular.models.CandidateSkills;
import com.ptl.exercise.Mindlance.simulator.angular.models.Skills;
import com.ptl.exercise.Mindlance.simulator.angular.repositories.CandidateRepository;
import com.ptl.exercise.Mindlance.simulator.angular.repositories.CandidateSkillsRepository;
import com.ptl.exercise.Mindlance.simulator.angular.repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
@RestController
public class CandidateController {

    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    CandidateSkillsRepository candidateSkillsRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/candidates")
    public List<CandidateDTO> candidate() {
        List<CandidateDTO> ldt = new ArrayList<>();
        for (Candidate c1 : (List<Candidate>) candidateRepository.findAll()) {
            CandidateDTO cdto = new CandidateDTO();
            cdto.setId(c1.getId());
            cdto.setName(c1.getName());
            cdto.setEmail(c1.getEmail());
            String skills = "";
            for (CandidateSkills cs : c1.getCandidateSkills()) {
                skills += cs.getSkills().getName() + ",";
            }
            cdto.setSkills(skills.substring(0, skills.length() - 1));
            cdto.setSkills(skills);
            ldt.add(cdto);
        }
        return ldt;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/candidates/{name}")
    public CandidateDTO show(@PathVariable("name") String name) {
        Candidate c = candidateRepository.findByName(name);
        CandidateDTO dto = new CandidateDTO();
        //List<CandidateSkills> cs = candidateSkillsRepository.findByCsk_Candidates(c);
        List<CandidateSkills> allcs = (List<CandidateSkills>) candidateSkillsRepository.findAll();
        List<CandidateSkills> cs = allcs.stream()
                .filter(cs1 -> cs1.getCandidate().getId() == c.getId())
                .collect(Collectors.toList());
        //try above
        dto.setAddress(c.getAddress());
        dto.setCity(c.getCity());
        dto.setEmail(c.getEmail());
        dto.setName(c.getName());
        dto.setPhone(c.getPhone());
        String skills = "";
        for (CandidateSkills cst : cs) {
            skills = cst.getSkills().getName() + ",";
        }
        dto.setSkills(skills.substring(0, skills.length() - 1));
        dto.setSkills(skills);
        return dto;
    }

    //name, email, comma separated skills
    @RequestMapping(method = RequestMethod.PUT, value = "/editSkill")
    public Candidate saveSkills(@RequestBody CandidateDTO candidate) {
        //todo
        Candidate matchCandidate = candidateRepository.findByName(candidate.getName());
        if (matchCandidate != null) {
            matchCandidate.setName(candidate.getName());
            matchCandidate.setEmail(candidate.getEmail());
            String[] skillsArray = candidate.getSkills().split(",");
            List<Skills> allSkills = (List<Skills>) skillsRepository.findAll();
            matchCandidate.setCandidateSkills(new ArrayList<>());
            for (String skillsName : skillsArray) {
                CandidateSkills cs = new CandidateSkills();
                cs.setCandidate(matchCandidate);
                Skills oneSkill = allSkills.stream()
                        .filter(s -> s.getName().equalsIgnoreCase(skillsName)).
                        findFirst()
                        .orElse(null);
                if (oneSkill != null) {
                    cs.setSkills(oneSkill);
                }
                matchCandidate.getCandidateSkills().add(cs);
            }
        }

        return matchCandidate;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addSkill")
    public Skills saveSkills(@RequestBody Skills skills) {
        //todo
        return skillsRepository.save(skills);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/skills")
    public List<SkillsDTO> getSkills() {
        //todo
        List<SkillsDTO> lst2 = new ArrayList<>();
        for (Skills s1 : (List<Skills>) skillsRepository.findAll()) {
            SkillsDTO sdto = new SkillsDTO(s1.getId(), s1.getName(), s1.getDescription());
            lst2.add(sdto);
        }
        return lst2;
    }
}

*/