package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onstatus;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class OnStatusRequest {
    private Context context;
    private OnStatusMessage message;
    private Error error;
}