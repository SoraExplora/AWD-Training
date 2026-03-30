package org.esprit.candidature.feignClient;

import org.esprit.candidature.dto.Candidat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CANDIDAT")
public interface CandidatClient {

    @GetMapping("/candidats/{id}")
    public Candidat getCandidat(@PathVariable int id);
}