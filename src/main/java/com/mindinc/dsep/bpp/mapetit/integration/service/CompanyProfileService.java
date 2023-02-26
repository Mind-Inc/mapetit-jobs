package com.mindinc.dsep.bpp.mapetit.integration.service;

import com.mindinc.dsep.bpp.mapetit.integration.mybatis.mapper.CompanyProfileMapper;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.CompanyProfile;
import com.mindinc.dsep.bpp.mapetit.provider.CompanyProfileProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyProfileService implements CompanyProfileProvider {

    private final CompanyProfileMapper companyProfileMapper;

    @Autowired
    public CompanyProfileService(CompanyProfileMapper companyProfileMapper) {
        this.companyProfileMapper = companyProfileMapper;
    }

    public Long create(CompanyProfile companyProfile) {
        this.companyProfileMapper.insertCompanyProfile(companyProfile);

        return companyProfile.getCompanyId();
    }

    public Optional<CompanyProfile> getCompanyProfile(Long companyId) {
        return this.companyProfileMapper.getCompanyProfile(companyId);
    }

    public List<CompanyProfile> getCompanyProfile(String userName) {
        return this.companyProfileMapper.getCompanyProfileByUserName(userName);
    }
}
