package org.esprit.candidature.feignClient;

import org.esprit.candidature.dto.Job;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="JOB")
public interface JobClient {
    @RequestMapping("/jobs")
    public List<Job> getAll();

    @RequestMapping("/jobs/{id}")
    public Job getById(@PathVariable int id);

}
