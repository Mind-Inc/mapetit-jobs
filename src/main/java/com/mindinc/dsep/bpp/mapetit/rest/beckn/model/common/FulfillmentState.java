package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FulfillmentState {

    private Descriptor descriptor;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("updated_by")
    private String updatedBy;
}
