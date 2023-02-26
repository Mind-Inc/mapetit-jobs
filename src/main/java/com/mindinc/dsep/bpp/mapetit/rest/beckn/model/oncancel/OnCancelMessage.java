package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.oncancel;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Order;
import lombok.Data;

@Data
public class OnCancelMessage {
    private Order order;
}
