package com.mindinc.dsep.bpp.mapetit.rest.beckn.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Order {
    private String id;

    @JsonProperty("ref_order_ids")
    private List<String> refOrderIds;
    private String status; //Enum [ ACTIVE, COMPLETE, CANCELLED ]
    private String type; //Enum [ DRAFT, DEFAULT ]
    private Provider provider;
    private List<Item> items;

    @JsonProperty("add_ons")
    private List<AddOn> addOns;

    private List<Offer> offers;
    //private List<Document> documents;
    private Billing billing;
    private List<Fulfillment> fulfillments;
    private Cancellation cancellation;

    @JsonProperty("cancellation_terms")
    private List<CancellationTerm> cancellationTerms;

    private Quotation quote;
    private List<Payment> payments;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    private XInput xinput;

    private List<TagGroup> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getRefOrderIds() {
        return refOrderIds;
    }

    public void setRefOrderIds(List<String> refOrderIds) {
        this.refOrderIds = refOrderIds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<AddOn> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOn> addOns) {
        this.addOns = addOns;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public List<Fulfillment> getFulfillments() {
        return fulfillments;
    }

    public void setFulfillments(List<Fulfillment> fulfillments) {
        this.fulfillments = fulfillments;
    }

    public Cancellation getCancellation() {
        return cancellation;
    }

    public void setCancellation(Cancellation cancellation) {
        this.cancellation = cancellation;
    }

    public List<CancellationTerm> getCancellationTerms() {
        return cancellationTerms;
    }

    public void setCancellationTerms(List<CancellationTerm> cancellationTerms) {
        this.cancellationTerms = cancellationTerms;
    }

    public Quotation getQuote() {
        return quote;
    }

    public void setQuote(Quotation quote) {
        this.quote = quote;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public XInput getXinput() {
        return xinput;
    }

    public void setXinput(XInput xinput) {
        this.xinput = xinput;
    }

    public List<TagGroup> getTags() {
        return tags;
    }

    public void setTags(List<TagGroup> tags) {
        this.tags = tags;
    }
}
