package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;


import com.mindinc.dsep.bpp.mapetit.rest.beckn.enums.AckStatus;

public class Ack {
    private AckStatus status;

    public Ack() {
    }

    public Ack(AckStatus status) {
        this.status = status;
    }

    public AckStatus getStatus() {
        return status;
    }

    public void setStatus(AckStatus status) {
        this.status = status;
    }
}