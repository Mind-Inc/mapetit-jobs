package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.oninit;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class OnInitRequest {
    private Context context;
    private OnInitMessage message;
    private Error error;
}