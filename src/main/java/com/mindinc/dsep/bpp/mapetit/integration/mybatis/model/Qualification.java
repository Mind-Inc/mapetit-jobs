package com.mindinc.dsep.bpp.mapetit.integration.mybatis.model;

public class Qualification {
    public enum Type {
        MINIMUM_EDUCATION("Minimum Educational Qualifications"),
        PREFERRED_EDUCATION("Preferred Educational Qualifications"),
        WORK_EXPERIENCE("Work Experience"),
        SKILLS("Skills");

        private String title;

        private Type(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
    private Long qualificationId;
    private Long jobId;
    private Type type;
    private String qualification;

    public Qualification(Long qualificationId, String type, String qualification) {
        this.qualificationId = qualificationId;
        this.type = Type.valueOf(type);
        this.qualification = qualification;
    }

    public Qualification(Type type, String qualification) {
        this.type = type;
        this.qualification = qualification;
    }

    public Long getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Long qualificationId) {
        this.qualificationId = qualificationId;
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

    public String getQualification() {
        return qualification;
    }
}
