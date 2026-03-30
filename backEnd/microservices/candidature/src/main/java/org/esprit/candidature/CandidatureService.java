package org.esprit.candidature;

import lombok.AllArgsConstructor;
import org.esprit.candidature.dto.Candidat;
import org.esprit.candidature.dto.Job;
import org.esprit.candidature.entity.Candidature;
import org.esprit.candidature.feignClient.CandidatClient;
import org.esprit.candidature.feignClient.JobClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CandidatureService {
    private JobClient jobServiceClient;
    private CandidatClient candidatServiceClient;
    private CandidatureRepo candidatureRepo;

    public List<Job> getJobs() {
        return jobServiceClient.getAll();
    }

    public Job getJobById(int id) {
        return jobServiceClient.getById(id);
    }

    public Candidat getCandidatById(int id) {
        return candidatServiceClient.getCandidat(id);
    }
    public Candidature saveCandidature(Candidature candidature) {
        candidatServiceClient.getCandidat(candidature.getCandId());
        jobServiceClient.getById(candidature.getJobId());
        return candidatureRepo.save(candidature);
    }

}
