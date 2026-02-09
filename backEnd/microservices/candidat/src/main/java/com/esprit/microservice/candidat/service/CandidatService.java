package com.esprit.microservice.candidat.service;

import com.esprit.microservice.candidat.entity.Candidat;
import com.esprit.microservice.candidat.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidateRepository;

    public Candidat addCandidat(Candidat c) {
        return candidateRepository.save(c);
    }

    public Candidat updateCandidat(int id, Candidat c) {
        if (candidateRepository.findById(id).isPresent()) {
            Candidat old = candidateRepository.findById(id).get();
            old.setNom(c.getNom());
            old.setPrenom(c.getPrenom());
            old.setEmail(c.getEmail());
            return candidateRepository.save(old);
        }
        return null;
    }

    public String deleteCandidat(int id) {
        if (candidateRepository.findById(id).isPresent()) {
            candidateRepository.deleteById(id);
            return "candidat supprimé";
        }
        return "candidat non supprimé";
    }
}
