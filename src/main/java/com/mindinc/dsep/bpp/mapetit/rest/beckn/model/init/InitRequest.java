package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.init;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class InitRequest {
    private Context context;
    private InitMessage message;
}
