package com.mindinc.dsep.bpp.mapetit.integration.mybatis.mapper;

import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.ContactDetail;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Job;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Qualification;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Responsibility;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Mapper
public interface JobMapper {
    @Insert({
        "INSERT INTO job",
        "(",
        "   company_id,",
        "   title,",
        "   job_location,",
        "   job_type,",
        "   employment_type,",
        "   description,",
        "   posted_on,",
        "   valid_until,",
        "   terms_and_condition",
        ") ",
        "VALUES",
        "(",
        "   #{companyId},",
        "   #{title},",
        "   #{location},",
        "   #{type},",
        "   #{employmentType},",
        "   #{description},",
        "   #{postedOn},",
        "   #{validUntil},",
        "   #{termsAndCondition}",
        ")"
    })
    @Options(useGeneratedKeys = true, keyProperty = "jobId")
    void insertJob(Job job);

    @Insert({
        "INSERT INTO job_qualification",
        "(",
        "   job_id,",
        "   qualification_type,",
        "   qualification",
        ") ",
        "VALUES",
        "(",
        "   #{jobId},",
        "   #{type},",
        "   #{qualification}",
        ")"
    })
    @Options(useGeneratedKeys = true, keyProperty = "qualificationId")
    void insertJobQualification(Qualification qualification);

    @Insert({
        "INSERT INTO job_responsibility",
        "(",
        "   job_id,",
        "   responsibility",
        ") ",
        "VALUES",
        "(",
        "   #{jobId},",
        "   #{responsibility}",
        ")"
    })
    @Options(useGeneratedKeys = true, keyProperty = "responsibilityId")
    void insertJobResponsibility(Responsibility responsibility);

    @Insert({
        "INSERT INTO job_contact",
        "(",
        "   job_id,",
        "   contact_type,",
        "   contact",
        ") ",
        "VALUES",
        "(",
        "   #{jobId},",
        "   #{type},",
        "   #{contact}",
        ")"
    })
    @Options(useGeneratedKeys = true, keyProperty = "contactId")
    void insertJobContactDetail(ContactDetail contactDetail);

    @Select({
        "<script>",
        "SELECT distinct",
        "   jb.job_id,",
        "   jb.company_id,",
        "   jb.title,",
        "   jb.job_location as location,",
        "   jb.job_type as type,",
        "   jb.employment_type,",
        "   jb.description,",
        "   jb.terms_and_condition,",
        "   jb.posted_on,",
        "   jb.valid_until",
        "FROM ",
        "   job jb JOIN job_qualification jbq on jb.job_id = jbq.job_id ",
        "          JOIN company_profile cp on cp.company_id = jb.company_id",
        "WHERE ",
        "   jb.title ILIKE CONCAT('%', #{title}, '%') ",
        "      or jb.description ILIKE CONCAT('%', #{description}, '%') ",
        "       <foreach item='item' index='index' collection='qualifications'> ",
        "           or jbq.qualification ILIKE CONCAT('%', #{item}, '%') ",
        "       </foreach>",
        "      or cp.\"name\" ILIKE CONCAT('%', #{companyName}, '%') ",
        "</script>"
    })
    Set<Job> findJobs(
            @Param("title") String title,
            @Param("description") String description,
            @Param("qualifications") List<String> qualifications,
            @Param("companyName") String companyName
    );

    @Select({
        "<script>",
        "SELECT ",
        "   jb.job_id,",
        "   jb.company_id,",
        "   jb.title,",
        "   jb.job_location as location,",
        "   jb.job_type as type,",
        "   jb.employment_type,",
        "   jb.description,",
        "   jb.terms_and_condition,",
        "   jb.posted_on,",
        "   jb.valid_until",
        "FROM ",
        "   job jb ",
        "WHERE ",
        "   jb.job_id = #{jobId}",
        "</script>"
    })
    Optional<Job> findJob(@Param("jobId") Long jobId);

    @Select({
        "SELECT ",
        "   qualification_id,",
        "   qualification_type,",
        "   qualification",
        "FROM ",
        "   job_qualification",
        "WHERE ",
        "   job_id = #{jobId}"
    })
    Set<Qualification> findQualification(@Param("jobId") Long jobId);

    @Select({
        "SELECT ",
        "   responsibility_id,",
        "   responsibility",
        "FROM ",
        "   job_responsibility",
        "WHERE ",
        "   job_id = #{jobId}"
    })
    Set<Responsibility> findResponsibility(@Param("jobId") Long jobId);

    @Select({
        "SELECT ",
        "   contact_id,",
        "   contact_type,",
        "   contact",
        "FROM ",
        "   job_contact",
        "WHERE ",
        "   job_id = #{jobId}"
    })
    Set<ContactDetail> findContactDetails(@Param("jobId") Long jobId);
}
