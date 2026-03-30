package org.esprit.job;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    public Job getById(int id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }

    public Job updateJob(int id, Job newJob) {

        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));

        existingJob.setTitle(newJob.getTitle());
        existingJob.setDescription(newJob.getDescription());
        existingJob.setAvailable(newJob.isAvailable());

        return jobRepository.save(existingJob);
    }

    public String deleteJob(int id) {

        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found with id: " + id);
        }

        jobRepository.deleteById(id);
        return "Job deleted successfully";
    }

    public List<Job> searchByTitle(String title) {
        return jobRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Job> searchByAvailability(boolean available) {
        return jobRepository.findByAvailable(available);
    }

    public List<Job> searchByTitleAndAvailability(String title, boolean available) {
        return jobRepository.findByTitleContainingIgnoreCaseAndAvailable(title, available);
    }
}
