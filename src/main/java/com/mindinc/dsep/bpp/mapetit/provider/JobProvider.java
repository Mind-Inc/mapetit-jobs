package com.mindinc.dsep.bpp.mapetit.provider;

import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Job;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface JobProvider {
    Optional<Job> getJob(String id);

    Set<Job> getJobs(String keyword);

    Set<Job> getJobs(String title, String description, List<String> qualifications, String companyName);
}
