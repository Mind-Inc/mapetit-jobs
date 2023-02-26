package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onupdate;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class OnUpdateRequest {
    private Context context;
    private OnUpdateMessage message;
}