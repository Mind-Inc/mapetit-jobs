package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Billing {
    private String name;
    private Organization organization;
    private String address;
    private State state;
    private City city;
    private String email;
    private String phone;
    private Time time;

    @JsonProperty("tax_id")
    private String taxId;
}
