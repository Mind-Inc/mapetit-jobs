package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimeRange {
    private String start;
    private String end;
}
