package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

import lombok.Data;

import java.util.List;

@Data
public class Quotation {
    private String id; //UUID
    private Price price;
    private List<QuotationBreakUp> breakup;
    private String ttl;
}
