package com.mindinc.dsep.bpp.mapetit.rest.model;

import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.CompanyProfile;

public record CompanyProfileResponse(
        Long companyId,
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
        String creatorUserName
) {
    public CompanyProfileResponse(Long companyId) {
        this(companyId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public static CompanyProfileResponse from(CompanyProfile cp) {
        return new CompanyProfileResponse(
                cp.getCompanyId(),
                cp.getName(),
                cp.getHandle(),
                cp.getLogo(),
                cp.getAddress(),
                cp.getWebsite(),
                cp.getTagline(),
                cp.getMission(),
                cp.getPurpose(),
                cp.getValueAndCulture(),
                cp.getShortDescription(),
                cp.getLongDescription(),
                cp.getWorkPlacePolicy(),
                cp.getIndustry(),
                cp.getCompanySize(),
                cp.getCompanyType(),
                cp.getCompanyGrowthDescription(),
                cp.getCreatorUserName()
        );
    }
}
