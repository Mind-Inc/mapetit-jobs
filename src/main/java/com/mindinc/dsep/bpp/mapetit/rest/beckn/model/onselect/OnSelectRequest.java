package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onselect;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class OnSelectRequest {
    private Context context;
    private OnSelectMessage message;
    private Error error;
}