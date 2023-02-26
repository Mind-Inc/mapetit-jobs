package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.onconfirm;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Order;
import lombok.Data;

@Data
public class OnConfirmMessage {
    private Order order;
}
