package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onupdate;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Order;
import lombok.Data;

@Data
public class OnUpdateMessage {
    private Order order;
}
