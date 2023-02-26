package com.mindinc.dsep.bpp.mapetit.rest.model;

import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.CompanyProfile;

public record CompanyProfileRequest(
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

    public CompanyProfile toModel() {
        return new CompanyProfile(
                companyId,
                name,
                handle,
                logo,
                address,
                website,
                tagline,
                mission,
                purpose,
                valueAndCulture,
                shortDescription,
                longDescription,
                workPlacePolicy,
                industry,
                companySize,
                companyType,
                companyGrowthDescription,
                creatorUserName,
                null,
                null
        );
    }
}
