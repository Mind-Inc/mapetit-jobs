package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

public class Fee {

    private String percentage;
    private Price amount;

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public Price getAmount() {
        return amount;
    }

    public void setAmount(Price amount) {
        this.amount = amount;
    }
}
