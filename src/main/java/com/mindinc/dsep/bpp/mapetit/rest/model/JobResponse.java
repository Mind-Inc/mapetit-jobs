package com.mindinc.dsep.bpp.mapetit.rest.model;

import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.ContactDetail;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Job;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Qualification;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Responsibility;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public record JobResponse(
        Long jobId,
        Long companyId,
        String title,
        String description,
        String location,
        String type,
        String employmentType,
        String termsAndCondition,
        Set<String> minimumEducation,
        Set<String> preferredEducation,
        Set<String> workExperience,
        Set<String> skills,
        Set<String> responsibilities,
        Optional<String> mobile,
        Optional<String> email,
        Optional<String> name,
        OffsetDateTime postedOn,
        OffsetDateTime validUntil
) {
    public JobResponse(Long jobId) {
        this(
                jobId,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                null,
                null
        );
    }

    public static JobResponse from(Job job) {
        return new JobResponse(
                job.getJobId(),
                job.getCompanyId(),
                job.getTitle(),
                job.getDescription(),
                job.getLocation(),
                job.getType().name(),
                job.getEmploymentType().name(),
                job.getTermsAndCondition(),
                job.getQualifications().stream()
                        .filter(q -> q.getType() == Qualification.Type.MINIMUM_EDUCATION)
                        .map(Qualification::getQualification)
                        .collect(Collectors.toSet()),
                job.getQualifications().stream()
                        .filter(q -> q.getType() == Qualification.Type.PREFERRED_EDUCATION)
                        .map(Qualification::getQualification)
                        .collect(Collectors.toSet()),
                job.getQualifications().stream()
                        .filter(q -> q.getType() == Qualification.Type.WORK_EXPERIENCE)
                        .map(Qualification::getQualification)
                        .collect(Collectors.toSet()),
                job.getQualifications().stream()
                        .filter(q -> q.getType() == Qualification.Type.SKILLS)
                        .map(Qualification::getQualification)
                        .collect(Collectors.toSet()),
                job.getResponsibilities().stream()
                        .map(Responsibility::getResponsibility)
                        .collect(Collectors.toSet()),
                job.getContactDetails().stream()
                        .filter(c -> c.getType() == ContactDetail.Type.MOBILE)
                        .map(ContactDetail::getContact).findFirst(),
                job.getContactDetails().stream()
                        .filter(c -> c.getType() == ContactDetail.Type.EMAIL)
                        .map(ContactDetail::getContact)
                        .findFirst(),
                job.getContactDetails().stream()
                        .filter(c -> c.getType() == ContactDetail.Type.NAME)
                        .map(ContactDetail::getContact)
                        .findFirst(),
                job.getPostedOn(),
                job.getValidUntil()
        );
    }
}
