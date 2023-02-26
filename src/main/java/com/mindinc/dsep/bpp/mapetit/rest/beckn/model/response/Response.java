package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.response;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Context;
import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Error;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Context context;
    private ResponseMessage message;
    private Error error;
}
