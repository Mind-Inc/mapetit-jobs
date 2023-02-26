package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.select;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Order;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SelectMessage {
    private Order order;
}
