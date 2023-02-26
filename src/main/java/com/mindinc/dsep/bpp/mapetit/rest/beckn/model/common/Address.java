package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

public class Address {
    private String full;    //Full unformatted address of a location.
    private String format;    //Defines the address formatting standard

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
