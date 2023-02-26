package com.mindinc.dsep.bpp.mapetit.integration.mybatis.model;

import java.time.OffsetDateTime;

public class CompanyProfile {
    private Long companyId;
    private String name;
    private String handle;
    private String logo;
    private String address;
    private String website;
    private String tagline;
    private String mission;
    private String purpose;
    private String valueAndCulture;
    private String shortDescription;
    private String longDescription;
    private String workPlacePolicy;
    private String industry;
    private Long companySize;
    private String companyType;
    private String companyGrowthDescription;
    private String creatorUserName;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public CompanyProfile(Long companyId,
                          String name,
                          String handle,
                          String logo,
                          String address,
                          String website,
                          String tagline,
                          String mission,
                          String purpose,
                          String valueAndCulture,
                          String shortDescription,
                          String longDescription,
                          String workPlacePolicy,
                          String industry,
                          Long companySize,
                          String companyType,
                          String companyGrowthDescription,
                          String creatorUserName,
                          OffsetDateTime createdAt,
                          OffsetDateTime updatedAt) {
        this.companyId = companyId;
        this.name = name;
        this.handle = handle;
        this.logo = logo;
        this.address = address;
        this.website = website;
        this.tagline = tagline;
        this.mission = mission;
        this.purpose = purpose;
        this.valueAndCulture = valueAndCulture;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.workPlacePolicy = workPlacePolicy;
        this.industry = industry;
        this.companySize = companySize;
        this.companyType = companyType;
        this.companyGrowthDescription = companyGrowthDescription;
        this.creatorUserName = creatorUserName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public String getHandle() {
        return handle;
    }

    public String getLogo() {
        return logo;
    }

    public String getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public String getTagline() {
        return tagline;
    }

    public String getMission() {
        return mission;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getValueAndCulture() {
        return valueAndCulture;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getWorkPlacePolicy() {
        return workPlacePolicy;
    }

    public String getIndustry() {
        return industry;
    }

    public Long getCompanySize() {
        return companySize;
    }

    public String getCompanyType() {
        return companyType;
    }

    public String getCompanyGrowthDescription() {
        return companyGrowthDescription;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
}
