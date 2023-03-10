package com.mindinc.dsep.bpp.mapetit.rest.controller;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.confirm.ConfirmRequest;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.response.Response;
import com.mindinc.dsep.bpp.mapetit.rest.builder.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/confirm")
public class ConfirmController {

    @PostMapping
    public Response search(@RequestBody ConfirmRequest body) {
        log.info("Received confirm request {}", body);

        return ResponseBuilder.buildResponseEntity(body.getContext());
    }

}
