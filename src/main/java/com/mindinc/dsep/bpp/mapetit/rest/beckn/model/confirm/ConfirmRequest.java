package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.confirm;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;

@Data
public class ConfirmRequest {
    private Context context;
    private ConfirmMessage message;
}
