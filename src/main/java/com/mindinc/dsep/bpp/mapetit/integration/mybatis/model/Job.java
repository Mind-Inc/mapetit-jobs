package com.mindinc.dsep.bpp.mapetit.integration.mybatis.model;

import java.time.OffsetDateTime;
import java.util.Set;

public class Job {
    public enum Type {
        REMOTE, HYBRID, ONSITE
    }

    private Long jobId;
    private Long companyId;
    private String title;
    private String description;
    private String location;
    private String termsAndCondition;
    private Type type;
    private EmploymentType employmentType;
    private Set<Qualification> qualifications;
    private Set<Responsibility> responsibilities;
    private Set<ContactDetail> contactDetails;
    private OffsetDateTime postedOn;
    private OffsetDateTime validUntil;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public Job() {
    }

    public Job(
            Long jobId,
            Long companyId,
            String title,
            String location,
            String type,
            String employmentType,
            String description,
            String termsAndCondition,
            OffsetDateTime postedOn,
            OffsetDateTime validUntil) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.termsAndCondition = termsAndCondition;
        this.location = location;
        this.type = Type.valueOf(type);
        this.employmentType = EmploymentType.valueOf(employmentType);
        this.postedOn = postedOn;
        this.validUntil = validUntil;
    }

    public Job(
            Long jobId,
            Long companyId,
            String title,
            String description,
            String location,
            String type,
            String employmentType,
            String termsAndConditions,
            Set<Qualification> qualifications,
            Set<Responsibility> responsibilities,
            Set<ContactDetail> contactDetails,
            OffsetDateTime postedOn,
            OffsetDateTime validUntil) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = Type.valueOf(type);
        this.employmentType = EmploymentType.valueOf(employmentType);
        this.termsAndCondition = termsAndConditions;
        this.qualifications = qualifications;
        this.responsibilities = responsibilities;
        this.contactDetails = contactDetails;
        this.postedOn = postedOn;
        this.validUntil = validUntil;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getTermsAndCondition() {
        return termsAndCondition;
    }

    public Type getType() {
        return type;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public Set<Qualification> getQualifications() {
        return qualifications;
    }

    public Set<Responsibility> getResponsibilities() {
        return responsibilities;
    }

    public Set<ContactDetail> getContactDetails() {
        return contactDetails;
    }

    public OffsetDateTime getPostedOn() {
        return postedOn;
    }

    public OffsetDateTime getValidUntil() {
        return validUntil;
    }

    public  Job withQualifications(Set<Qualification> qualifications) {
        this.qualifications = qualifications;
        return this;
    }

    public  Job withResponsibilities(Set<Responsibility> responsibilities) {
        this.responsibilities = responsibilities;
        return this;
    }

    public  Job withContactDetails(Set<ContactDetail> contactDetails) {
        this.contactDetails = contactDetails;
        return this;
    }
}
