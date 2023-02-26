package com.mindinc.dsep.bpp.mapetit.rest.controller;

import com.mindinc.dsep.bpp.mapetit.integration.service.JobService;
import com.mindinc.dsep.bpp.mapetit.rest.model.JobRequest;
import com.mindinc.dsep.bpp.mapetit.rest.model.JobResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/jobs")
@Tag(name = "company profile", description = "the company profile API")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public JobResponse createJob(@RequestBody JobRequest jobRequest) {
        var jobId = jobService.create(jobRequest.toModel());

        return new JobResponse(jobId);
    }

    @GetMapping("/search/{keyWord}")
    public List<JobResponse> getCompanyProfile(@PathVariable("keyWord") String keyWord) {
        return jobService.getJobs(keyWord)
                .stream()
                .map(JobResponse::from)
                .toList();
    }
}
