package org.esprit.candidature;

import org.esprit.candidature.entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepo extends JpaRepository<Candidature, Integer> {
}
