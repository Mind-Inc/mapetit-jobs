package com.mindinc.dsep.bpp.mapetit.integration.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Job;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Qualification;
import com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Responsibility;
import com.mindinc.dsep.bpp.mapetit.provider.CompanyProfileProvider;
import com.mindinc.dsep.bpp.mapetit.provider.JobProvider;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.enums.ContextAction;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Descriptor;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Form;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Fulfillment;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Item;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Order;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Tag;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.TagGroup;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Time;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.TimeRange;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.XInput;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.init.InitMessage;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.init.InitRequest;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onselect.OnSelectMessage;
import com.mindinc.dsep.bpp.mapetit.rest.builder.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Qualification.Type.MINIMUM_EDUCATION;
import static com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Qualification.Type.PREFERRED_EDUCATION;
import static com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Qualification.Type.SKILLS;
import static com.mindinc.dsep.bpp.mapetit.integration.mybatis.model.Qualification.Type.WORK_EXPERIENCE;

@Slf4j
@Service
public class OnInitService {

    private final RestService restService;
    private final JobProvider jobProvider;
    private final CompanyProfileProvider companyProfileProvider;

    @Autowired
    public OnInitService(
            JobProvider jobProvider,
            CompanyProfileProvider companyProfileProvider,
            RestService restService) {
        this.restService = restService;
        this.jobProvider = jobProvider;
        this.companyProfileProvider = companyProfileProvider;
    }

    public void execute(InitRequest initRequest) throws JsonProcessingException {
        Objects.requireNonNull(initRequest);

        var jobId = Optional.of(initRequest)
                .map(InitRequest::getMessage)
                .map(InitMessage::getOrder)
                .map(Order::getItems)
                .flatMap(items -> items.stream().findFirst())
                .map(Item::getId)
                .orElse("NOT APPLICABLE");

        var job = jobProvider.getJob(jobId).orElseThrow();
        var context = ResponseBuilder.buildContext(initRequest.getContext(), ContextAction.ON_INIT.value());
        var order = buildOrder(job, initRequest.getMessage().getOrder().getFulfillments());
        var requestBody = OnSelectMessage.builder()
                .order(order)
                .build();
        var url = context.getBapUri().concat(ContextAction.ON_INIT.value());

        log.info("Sending request to BAP: {}", url);

        restService.post(requestBody, url);
    }

    private Order buildOrder(Job job, List<Fulfillment> fulfillments) {
        var locationId = UUID.randomUUID().toString();
        Order order = new Order();
        order.setItems(toItems(job, locationId));
        order.setXinput(XInput.builder()
                .form(Form.builder().url("https://mapetit.app/dsep/v1/xinput/" + job.getJobId()).build())
                .build()
        );
        order.setFulfillments(fulfillments);

        return order;
    }

    private List<Item> toItems(Job job, String locationId) {
        var item = Item.builder()
                .id(String.valueOf(job.getJobId()))
                .descriptor(Descriptor.builder().name(job.getTitle()).longDesc(job.getDescription()).build())
                .fulfillmentIds(List.of(job.getType().name()))
                .locationIds(List.of(locationId))
                .time(new Time(
                        TimeRange.builder()
                                .end(ResponseBuilder.getDateTimeString(job.getPostedOn()))
                                .start(ResponseBuilder.getDateTimeString(job.getValidUntil()))
                                .build()
                ))
                .tags(
                        List.of(
                                TagGroup.builder()
                                        .descriptor(new Descriptor(MINIMUM_EDUCATION.getTitle()))
                                        .list(
                                                job.getQualifications().stream()
                                                        .filter(q -> q.getType() == MINIMUM_EDUCATION)
                                                        .map(Qualification::getQualification)
                                                        .map(Descriptor::new)
                                                        .map(Tag::new)
                                                        .toList()
                                        )
                                        .build(),
                                TagGroup.builder()
                                        .descriptor(new Descriptor(PREFERRED_EDUCATION.getTitle()))
                                        .list(
                                                job.getQualifications().stream()
                                                        .filter(q -> q.getType() == PREFERRED_EDUCATION)
                                                        .map(Qualification::getQualification)
                                                        .map(Descriptor::new)
                                                        .map(Tag::new)
                                                        .toList()
                                        )
                                        .build(),
                                TagGroup.builder()
                                        .descriptor(new Descriptor(WORK_EXPERIENCE.getTitle()))
                                        .list(
                                                job.getQualifications().stream()
                                                        .filter(q -> q.getType() == WORK_EXPERIENCE)
                                                        .map(Qualification::getQualification)
                                                        .map(Descriptor::new)
                                                        .map(Tag::new)
                                                        .toList()
                                        )
                                        .build(),
                                TagGroup.builder()
                                        .descriptor(new Descriptor(SKILLS.getTitle()))
                                        .list(
                                                job.getQualifications().stream()
                                                        .filter(q -> q.getType() == SKILLS)
                                                        .map(Qualification::getQualification)
                                                        .map(Descriptor::new)
                                                        .map(Tag::new)
                                                        .toList()
                                        )
                                        .build(),
                                TagGroup.builder()
                                        .descriptor(new Descriptor("Responsibilities"))
                                        .list(
                                                job.getResponsibilities().stream()
                                                        .map(Responsibility::getResponsibility)
                                                        .map(Descriptor::new)
                                                        .map(Tag::new)
                                                        .toList()
                                        )
                                        .build(),
                                TagGroup.builder()
                                        .descriptor(new Descriptor("Employment type"))
                                        .list(
                                                List.of(new Tag(new Descriptor(job.getEmploymentType().name())))
                                        )
                                        .build()
                        )
                )
                .build();

        return List.of(item);
    }
}
