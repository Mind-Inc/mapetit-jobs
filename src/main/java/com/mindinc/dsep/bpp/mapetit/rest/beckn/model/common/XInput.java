package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class XInput {
    @JsonProperty("form")
    private Form form;

    private boolean required;

    @JsonProperty("form_submission")
    private Object formSubmission;
}
