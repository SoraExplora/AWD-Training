package com.esprit.microservice.candidat.controller;

import com.esprit.microservice.candidat.entity.Candidat;
import com.esprit.microservice.candidat.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class CandidatRestAPI {

    private String title = "Hello, i'm the candidate Micro-Service";

    @RequestMapping("/hello")
    public String sayHello() {
        return title;
    }
    @Autowired
    private CandidatService candidatService;

    @PostMapping
    public Candidat create(@RequestBody Candidat c) {
        return candidatService.addCandidat(c);
    }

    @PutMapping("/{id}")
    public Candidat update(@PathVariable int id, @RequestBody Candidat c) {
        return candidatService.updateCandidat(id, c);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return candidatService.deleteCandidat(id);
    }

}