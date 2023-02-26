package com.mindinc.dsep.bpp.mapetit.integration.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Job;
import com.mindinc.dsep.bpp.mapetit.provider.CompanyProfileProvider;
import com.mindinc.dsep.bpp.mapetit.provider.JobProvider;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.enums.ContextAction;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Catalog;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.City;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Country;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Descriptor;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Intent;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Item;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Location;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Provider;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.State;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Tag;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.TagGroup;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onsearch.OnSearchMessage;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onsearch.OnSearchRequest;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.search.SearchMessage;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.search.SearchRequest;
import com.mindinc.dsep.bpp.mapetit.rest.builder.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
public class OnSearchService {

    private final RestService restService;
    private final JobProvider jobProvider;
    private final CompanyProfileProvider companyProfileProvider;

    @Autowired
    public OnSearchService(
            JobProvider jobProvider,
            CompanyProfileProvider companyProfileProvider,
            RestService restService) {
        this.restService = restService;
        this.jobProvider = jobProvider;
        this.companyProfileProvider = companyProfileProvider;
    }

    public void execute(SearchRequest searchRequest) throws JsonProcessingException {
        Objects.requireNonNull(searchRequest);

        var companyName = Optional.of(searchRequest)
                .map(SearchRequest::getMessage)
                .map(SearchMessage::getIntent)
                .map(Intent::getProvider)
                .map(Provider::getDescriptor)
                .map(Descriptor::getName)
                .orElse("NOT APPLICABLE");

        var jobTitle = Optional.of(searchRequest)
                .map(SearchRequest::getMessage)
                .map(SearchMessage::getIntent)
                .map(Intent::getItem)
                .map(Item::getDescriptor)
                .map(Descriptor::getName)
                .orElse("NOT APPLICABLE");

        var skills = Optional.of(searchRequest)
                .map(SearchRequest::getMessage)
                .map(SearchMessage::getIntent)
                .map(Intent::getItem)
                .map(Item::getTags)
                .map(tags -> tags.stream()
                            .map(TagGroup::getList)
                            .flatMap(List::stream)
                            .map(Tag::getValue)
                            .toList()
                )
                .orElse(List.of());

        var jobs = jobProvider.getJobs(jobTitle, jobTitle, skills, companyName);
        var context = ResponseBuilder.buildContext(searchRequest.getContext(), ContextAction.ON_SEARCH.value());
        var catalog = buildCatalog(jobs);
        var requestBody = OnSearchRequest.builder()
                .context(context)
                .message(OnSearchMessage.builder()
                        .catalog(catalog)
                        .build())
                .build();
        var url = context.getBapUri().concat(ContextAction.ON_SEARCH.value());

        log.info("Sending request to BAP: {}", url);

        restService.post(requestBody, url);
    }

    private Catalog buildCatalog(Set<Job> jobs) {
        Catalog catalog = new Catalog();
        catalog.setBppDescriptor(new Descriptor("Mapetit jobs"));
        catalog.setBppProviders(jobs.stream().map(this::jobToProvider).toList());

        return catalog;
    }

    private Provider jobToProvider(Job job) {

        var companyProfile = companyProfileProvider.getCompanyProfile(job.getCompanyId()).orElse(null);
        assert companyProfile != null;

        Provider provider = new Provider();
        provider.setId(String.valueOf(job.getCompanyId()));
        provider.setDescriptor(new Descriptor(companyProfile.getName()));

        provider.setLocations(
                List.of(
                        Location.builder()
                                .id(UUID.randomUUID().toString())
                                .address("Golden gates 10")
                                .city(City.builder().name("Bangalore").build())
                                .state(State.builder().name("Karnataka").build())
                                .country(Country.builder().name("India").build())
                                .build()
                )
        );

        provider.setItems(
                List.of(
                        Item.builder()
                                .id(String.valueOf(job.getJobId()))
                                .descriptor(Descriptor.builder()
                                        .name(job.getTitle())
                                        .longDesc(job.getDescription())
                                        .build())
                                .locationIds(List.of("1"))
                                .build()
                )
        );

        return provider;
    }
}
