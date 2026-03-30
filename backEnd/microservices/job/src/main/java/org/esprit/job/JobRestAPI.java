package org.esprit.job;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobRestAPI {
    private final JobService jobService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, I'm the Job MS";
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAll() {
        return ResponseEntity.ok(jobService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getById(@PathVariable int id) {
        return ResponseEntity.ok(jobService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.addJob(job), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable int id,
                                         @RequestBody Job job) {
        return ResponseEntity.ok(jobService.updateJob(id, job));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        return ResponseEntity.ok(jobService.deleteJob(id));
    }
    @GetMapping("/search/title")
    public ResponseEntity<List<Job>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(jobService.searchByTitle(title));
    }

    // Search by availability
    @GetMapping("/search/available")
    public ResponseEntity<List<Job>> searchByAvailability(@RequestParam boolean available) {
        return ResponseEntity.ok(jobService.searchByAvailability(available));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchByTitleAndAvailability(
            @RequestParam String title,
            @RequestParam boolean available) {

        return ResponseEntity.ok(
                jobService.searchByTitleAndAvailability(title, available));
    }
}
