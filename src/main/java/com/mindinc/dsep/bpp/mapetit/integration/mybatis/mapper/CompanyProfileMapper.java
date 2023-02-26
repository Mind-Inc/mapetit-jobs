package com.mindinc.dsep.bpp.mapetit.integration.mybatis.mapper;

import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.CompanyProfile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CompanyProfileMapper {
    @Insert({
        "INSERT INTO company_profile",
        "(",
        "   \"name\",",
        "   handle,",
        "   logo,",
        "   website,",
        "   address,",
        "   industry,",
        "   company_type,",
        "   tagline,",
        "   mission,",
        "   purpose,",
        "   value_and_culture,",
        "   short_description,",
        "   long_description,",
        "   workplace_policy,",
        "   company_growth_description,",
        "   company_size,",
        "   creator_user_name",
        ") ",
        "VALUES",
        "(",
        "   #{name},",
        "   #{handle},",
        "   #{logo},",
        "   #{website},",
        "   #{address},",
        "   #{industry},",
        "   #{companyType},",
        "   #{tagline},",
        "   #{mission},",
        "   #{purpose},",
        "   #{valueAndCulture},",
        "   #{shortDescription},",
        "   #{longDescription},",
        "   #{workPlacePolicy},",
        "   #{companyGrowthDescription},",
        "   #{companySize},",
        "   #{creatorUserName}",
        ")"
    })
    @Options(useGeneratedKeys = true, keyProperty = "companyId")
    void insertCompanyProfile(CompanyProfile companyProfile);

    @Select({
        "SELECT ",
        "   company_id,",
        "   \"name\",",
        "   handle,",
        "   logo,",
        "   address,",
        "   website,",
        "   tagline,",
        "   mission,",
        "   purpose,",
        "   value_and_culture,",
        "   short_description,",
        "   long_description,",
        "   workplace_policy,",
        "   industry,",
        "   company_size,",
        "   company_type,",
        "   company_growth_description,",
        "   creator_user_name,",
        "   created_at,",
        "   updated_at",
        "FROM ",
        "   company_profile",
        "WHERE ",
        "   company_id = #{companyId}"
    })
    Optional<CompanyProfile> getCompanyProfile(Long companyId);

    @Select({
        "SELECT ",
        "   company_id,",
        "   \"name\",",
        "   handle,",
        "   logo,",
        "   address,",
        "   website,",
        "   tagline,",
        "   mission,",
        "   purpose,",
        "   value_and_culture,",
        "   short_description,",
        "   long_description,",
        "   workplace_policy,",
        "   industry,",
        "   company_size,",
        "   company_type,",
        "   company_growth_description,",
        "   creator_user_name,",
        "   created_at,",
        "   updated_at",
        "FROM ",
        "   company_profile",
        "WHERE ",
        "   creator_user_name = #{userName}"
    })
    List<CompanyProfile> getCompanyProfileByUserName(String userName);
}
