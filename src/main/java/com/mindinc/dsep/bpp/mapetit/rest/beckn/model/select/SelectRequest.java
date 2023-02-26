package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.select;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SelectRequest {
    private Context context;
    private SelectMessage message;
}
