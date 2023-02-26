package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.cancel;

import com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common.Descriptor;

public class CancelMessage {
    private String orderId;
    private String cancellationReasonId;
    private Descriptor descriptor;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCancellationReasonId() {
        return cancellationReasonId;
    }

    public void setCancellationReasonId(String cancellationReasonId) {
        this.cancellationReasonId = cancellationReasonId;
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }
}