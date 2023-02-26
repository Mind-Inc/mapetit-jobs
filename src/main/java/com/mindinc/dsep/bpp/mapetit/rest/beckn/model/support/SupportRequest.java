package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.support;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class SupportRequest {
    private Context context;
    private SupportMessage message;
}
