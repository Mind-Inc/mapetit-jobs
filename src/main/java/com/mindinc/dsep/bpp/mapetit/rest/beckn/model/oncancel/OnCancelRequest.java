package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.oncancel;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class OnCancelRequest {
    private Context context;
    private OnCancelMessage message;
}