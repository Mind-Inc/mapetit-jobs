package com.mindinc.dsep.bpp.mapetit.rest.model;


import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.ContactDetail;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Job;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Qualification;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Responsibility;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Qualification.Type.MINIMUM_EDUCATION;
import static com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Qualification.Type.PREFERRED_EDUCATION;

public record JobRequest(
    Long companyId,
    String title,
    String description,
    String location,
    String type,
    String employmentType,
    Set<String> minimumEducation,
    Set<String> preferredEducation,
    Set<String> workExperience,
    Set<String> skills,
    Set<String> responsibilities,
    String mobile,
    String email,
    String name,
    String termsAndCondition,
    OffsetDateTime postedOn,
    OffsetDateTime validUntil
) {
    public Job toModel() {

        var qualifications = Stream.concat(
                    Stream.concat(
                            minimumEducation.stream()
                                    .map(minEducation ->
                                            new Qualification(MINIMUM_EDUCATION, minEducation)
                                    ),
                            preferredEducation.stream()
                                    .map(preferredEducation ->
                                            new Qualification(PREFERRED_EDUCATION, preferredEducation)
                                    )
                    ),
                    Stream.concat(
                            workExperience.stream().map(workExperience ->
                                    new Qualification(Qualification.Type.WORK_EXPERIENCE, workExperience)
                            ),
                            skills.stream().map(skill ->
                                    new Qualification(Qualification.Type.SKILLS, skill)
                            )
                    )
                )
                .collect(Collectors.toSet());

        var contactDetails = Set.of(
                new ContactDetail(ContactDetail.Type.NAME, name),
                new ContactDetail(ContactDetail.Type.EMAIL, email),
                new ContactDetail(ContactDetail.Type.MOBILE, email)
        );

        return new Job(
                null,
                companyId,
                title,
                description,
                location,
                type,
                employmentType,
                termsAndCondition,
                qualifications,
                responsibilities.stream().map(Responsibility::new).collect(Collectors.toSet()),
                contactDetails,
                postedOn,
                validUntil
        );
    }
}
