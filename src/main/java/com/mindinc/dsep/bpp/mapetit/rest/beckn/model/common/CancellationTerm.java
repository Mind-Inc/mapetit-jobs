package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CancellationTerm {

    @JsonProperty("fulfillment_state")
    private FulfillmentState fulfillmentState;

    @JsonProperty("reason_required")
    private boolean reasonRequired;

    @JsonProperty("cancel_by")
    private Time cancelBy;

    @JsonProperty("cancellation_fee")
    private Fee cancellationFee;
    private XInput xinput;

    @JsonProperty("external_ref")
    private MediaFile externalRef;
}
