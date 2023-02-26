package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onselect;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Order;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OnSelectMessage {
    private Order order;
}
