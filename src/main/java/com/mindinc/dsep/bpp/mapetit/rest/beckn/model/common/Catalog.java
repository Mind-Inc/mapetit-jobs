package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Catalog {
    @JsonProperty("descriptor")
    private Descriptor bppDescriptor;

    @JsonProperty("fulfillments")
    private List<Fulfillment> bppFulfillments;

    @JsonProperty("payments")
    private List<Payment> bppPayments;

    @JsonProperty("offers")
    private List<Offer> bppOffers;

    @JsonProperty("providers")
    private List<Provider> bppProviders;

    private String exp;

    private String ttl;

    public Descriptor getBppDescriptor() {
        return bppDescriptor;
    }

    public void setBppDescriptor(Descriptor bppDescriptor) {
        this.bppDescriptor = bppDescriptor;
    }

    public List<Fulfillment> getBppFulfillments() {
        return bppFulfillments;
    }

    public void setBppFulfillments(List<Fulfillment> bppFulfillments) {
        this.bppFulfillments = bppFulfillments;
    }

    public List<Payment> getBppPayments() {
        return bppPayments;
    }

    public void setBppPayments(List<Payment> bppPayments) {
        this.bppPayments = bppPayments;
    }

    public List<Offer> getBppOffers() {
        return bppOffers;
    }

    public void setBppOffers(List<Offer> bppOffers) {
        this.bppOffers = bppOffers;
    }

    public List<Provider> getBppProviders() {
        return bppProviders;
    }

    public void setBppProviders(List<Provider> bppProviders) {
        this.bppProviders = bppProviders;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
}
