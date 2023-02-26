package com.mindinc.dsep.bpp.mapetit.integration.service;

import com.mindinc.dsep.bpp.mapetit.integration.mybatis.mapper.JobMapper;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Job;
import com.mindinc.dsep.bpp.mapetit.provider.JobProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobService implements JobProvider {

    private final JobMapper jobMapper;

    @Autowired
    public JobService(JobMapper jobMapper) {
        this.jobMapper = jobMapper;
    }

    @Transactional
    public Long create(Job job) {
        this.jobMapper.insertJob(job);

        job.getQualifications().forEach(qualification -> {
            qualification.setJobId(job.getJobId());
            this.jobMapper.insertJobQualification(qualification);
        });


        job.getResponsibilities().forEach(responsibility -> {
            responsibility.setJobId(job.getJobId());
            this.jobMapper.insertJobResponsibility(responsibility);
        });

        job.getContactDetails().forEach(contactDetail -> {
            contactDetail.setJobId(job.getJobId());
            this.jobMapper.insertJobContactDetail(contactDetail);
        });

        return job.getJobId();
    }

    public Optional<Job> getJob(String id) {
        return this.jobMapper.findJob(Long.parseLong(id))
                .map(this::includeJobQualifications)
                .map(this::includeJobResponsibilities)
                .map(this::includeJobContactDetails);
    }

    public Set<Job> getJobs(String keyword) {
        return this.jobMapper.findJobs(keyword, keyword, List.of(keyword), keyword)
                .stream()
                .map(this::includeJobQualifications)
                .map(this::includeJobResponsibilities)
                .map(this::includeJobContactDetails)
                .collect(Collectors.toSet());
    }

    public Set<Job> getJobs(String title, String description, List<String> qualifications, String companyName) {
        return this.jobMapper.findJobs(title, description, qualifications, companyName)
                .stream()
                .map(this::includeJobQualifications)
                .map(this::includeJobResponsibilities)
                .map(this::includeJobContactDetails)
                .collect(Collectors.toSet());
    }

    private Job includeJobContactDetails(Job job) {
        return job.withContactDetails(jobMapper.findContactDetails(job.getJobId()));
    }

    private Job includeJobResponsibilities(Job job) {
        return job.withResponsibilities(jobMapper.findResponsibility(job.getJobId()));
    }

    private Job includeJobQualifications(Job job) {
        return job.withQualifications(jobMapper.findQualification(job.getJobId()));
    }
}
