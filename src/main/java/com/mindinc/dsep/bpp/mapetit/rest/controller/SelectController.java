package com.mindinc.dsep.bpp.mapetit.rest.controller;

import com.mindinc.dsep.bpp.mapetit.integration.service.OnSelectService;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.response.Response;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.select.SelectRequest;
import com.mindinc.dsep.bpp.mapetit.rest.builder.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/v1/select")
public class SelectController {

    private final OnSelectService onSelectService;

    @Autowired
    public SelectController(OnSelectService onSelectService) {
        this.onSelectService = onSelectService;
    }

    @PostMapping
    public Response search(@RequestBody SelectRequest body) {
        log.info("Received select request {}", body);
        CompletableFuture.runAsync(() -> {
            try {
                this.onSelectService.execute(body);
            } catch (Exception e) {
                log.error("error while sending on_select reply", e);
            }
        });

        return ResponseBuilder.buildResponseEntity(body.getContext());
    }

}
