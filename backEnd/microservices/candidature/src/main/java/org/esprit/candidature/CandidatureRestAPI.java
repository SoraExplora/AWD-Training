package org.esprit.candidature;

import lombok.AllArgsConstructor;
import org.esprit.candidature.dto.Candidat;
import org.esprit.candidature.dto.Job;
import org.esprit.candidature.entity.Candidature;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidatures")
@AllArgsConstructor
public class CandidatureRestAPI {
    private final CandidatureService candidatureService;
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Im microservice 3!";
    }

    @RequestMapping("/jobs")
    public List<Job> getAllJobs() {
        return candidatureService.getJobs();
    }

    @RequestMapping("jobs/{id}")
    public Job getJobById(@PathVariable int id) {
        return candidatureService.getJobById(id);
    }
    // Le reste des ressources liées à l’API Candidature
    @GetMapping("/candidat/{id}")
    public Candidat candidat(@PathVariable int id){
        return candidatureService.getCandidatById(id);
    }


    @PostMapping
    public Candidature createCandidature(@RequestBody Candidature candidature) {
        return candidatureService.saveCandidature(candidature);
    }
}
