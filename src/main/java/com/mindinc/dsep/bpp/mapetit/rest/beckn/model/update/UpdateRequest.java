package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.update;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class UpdateRequest {
    private Context context;
    private UpdateMessage message;
}