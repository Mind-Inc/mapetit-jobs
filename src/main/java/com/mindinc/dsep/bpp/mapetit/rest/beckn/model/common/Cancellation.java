package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Cancellation {

    private String time;

    @JsonProperty("cancelled_by")
    private String cancelledBy;
    private Option reason;

    @JsonProperty("additional_description")
    private Descriptor additionalDescription;
}
