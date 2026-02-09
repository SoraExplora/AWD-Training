package com.esprit.microservice.candidat.repository;

import com.esprit.microservice.candidat.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidatRepository extends JpaRepository<Candidat, Integer> {

    @Query("select c from Candidat c where c.nom like :name")
    Page<Candidat> candidatByNom(@Param("name") String name, Pageable pageable);
}
