package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onconfirm;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class OnConfirmRequest {
    private Context context;
    private OnConfirmMessage message;
    private Error error;
}
