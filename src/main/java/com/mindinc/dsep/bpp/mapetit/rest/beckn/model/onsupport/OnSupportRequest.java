package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onsupport;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class OnSupportRequest {
    private Context context;
    private OnSupportMessage message;
}
