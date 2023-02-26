package com.mindinc.dsep.bpp.mapetit.integration.mybatis.model;

public class Responsibility {
    private Long responsibilityId;
    private Long jobId;
    private String responsibility;

    public Responsibility(Long responsibilityId, String responsibility) {
        this.responsibilityId = responsibilityId;
        this.responsibility = responsibility;
    }

    public Responsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public Long getResponsibilityId() {
        return responsibilityId;
    }

    public void setResponsibilityId(Long responsibilityId) {
        this.responsibilityId = responsibilityId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getResponsibility() {
        return responsibility;
    }
}
