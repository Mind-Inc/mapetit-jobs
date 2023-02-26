package com.mindinc.dsep.bpp.mapetit.provider;

import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.CompanyProfile;

import java.util.Optional;

public interface CompanyProfileProvider {
    Optional<CompanyProfile> getCompanyProfile(Long companyId);
}
