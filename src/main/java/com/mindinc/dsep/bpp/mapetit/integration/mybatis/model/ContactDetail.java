package com.mindinc.dsep.bpp.mapetit.integration.mybatis.model;

public class ContactDetail {
    public enum Type {
        MOBILE, EMAIL, NAME
    }
    private Long contactId;
    private Long jobId;
    private Type type;
    private String contact;

    public ContactDetail(Long contactId, String type, String contact) {
        this.contactId = contactId;
        this.type = Type.valueOf(type);
        this.contact = contact;
    }

    public ContactDetail(Type type, String contact) {
        this.type = type;
        this.contact = contact;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Type getType() {
        return type;
    }

    public String getContact() {
        return contact;
    }
}
