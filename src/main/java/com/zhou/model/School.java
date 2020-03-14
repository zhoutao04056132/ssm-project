package com.zhou.model;

public class School {
    private Integer id;
    private String name;
    private String code;
    private String logo;
    private Integer provinceId;
    private String provinceName;
    private Integer sourceId;
    private String sourceName;
    private String subjectionName;
    private String summary;
    private String shortPinyin;
    private Byte isDeleted;

    public School() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSubjectionName() {
        return subjectionName;
    }

    public void setSubjectionName(String subjectionName) {
        this.subjectionName = subjectionName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getShortPinyin() {
        return shortPinyin;
    }

    public void setShortPinyin(String shortPinyin) {
        this.shortPinyin = shortPinyin;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", logo='" + logo + '\'' +
                ", provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                ", sourceId=" + sourceId +
                ", sourceName='" + sourceName + '\'' +
                ", subjectionName='" + subjectionName + '\'' +
                ", summary='" + summary + '\'' +
                ", shortPinyin='" + shortPinyin + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
