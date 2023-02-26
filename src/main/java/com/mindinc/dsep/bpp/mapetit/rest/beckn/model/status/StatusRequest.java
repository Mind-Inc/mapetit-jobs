package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.status;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class StatusRequest {
    private Context context;
    private StatusMessage message;
}
