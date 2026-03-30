package org.esprit.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findByTitleContainingIgnoreCase(String title);
    List<Job> findByAvailable(boolean available);
    List<Job> findByTitleContainingIgnoreCaseAndAvailable(String title, boolean available);
}
