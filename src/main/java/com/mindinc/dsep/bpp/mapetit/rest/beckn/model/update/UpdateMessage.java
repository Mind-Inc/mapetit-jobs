package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.update;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Order;
import lombok.Data;

@Data
public class UpdateMessage {
    private String updateTarget;
    private Order order;
}
