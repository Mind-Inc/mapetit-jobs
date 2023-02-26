package com.mindinc.dsep.bpp.mapetit.rest.controller;

import com.mindinc.dsep.bpp.mapetit.integration.service.CompanyProfileService;
import com.mindinc.dsep.bpp.mapetit.rest.model.CompanyProfileRequest;
import com.mindinc.dsep.bpp.mapetit.rest.model.CompanyProfileResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/companies/profiles")
@Tag(name = "company profile", description = "the company profile API")
public class CompanyProfileController {

    private final CompanyProfileService companyProfileService;

    public CompanyProfileController(CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

    @PostMapping
    public CompanyProfileResponse createCompanyProfile(@RequestBody CompanyProfileRequest companyProfileRequest) {
        var companyId = companyProfileService.create(companyProfileRequest.toModel());

        return new CompanyProfileResponse(companyId);
    }

    @GetMapping("/{companyId}")
    public Optional<CompanyProfileResponse> getCompanyProfile(@PathVariable("companyId") Long companyId) {
        return companyProfileService.getCompanyProfile(companyId)
                .map(CompanyProfileResponse::from);
    }

    @GetMapping("/creators/{userName}")
    public List<CompanyProfileResponse> getCompanyProfile(@PathVariable("userName") String userName) {
        return companyProfileService.getCompanyProfile(userName)
                .stream()
                .map(CompanyProfileResponse::from)
                .toList();
    }
}
