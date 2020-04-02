package com.zhou.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User1 {
    private Integer id;
    private String name;
    private String password;
    private String mobile;
    private String weChart;
    private String qq;
    private String email;
    private String realName;
    private Byte sex;
    private String portrait;
    private Integer provinceId;
    private String provinceCode;
    private String provinceName;
    private Integer cityId;
    private String cityCode;
    private String cityName;
    private Integer districtId;
    private String districtCode;
    private String districtName;
    private Integer highSchoolId;
    private String highSchoolName;
    // 年级，命名和班级保持一致
    private String gradeName;
    // 为了避免和关键字class冲突
    private String className;
    private Integer scienceTypeId;
    private Integer vipLevelId;
    private Integer graduateYear;
    private Integer growth;
    private Integer integral;
    private Byte ifCompletedInformation;
    private String createBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(
            pattern = "yyyy-MM-dd hh:mm:ss",
            timezone = "GMT+8"
    )
    private Date createTime;
    private String updateBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(
            pattern = "yyyy-MM-dd hh:mm:ss",
            timezone = "GMT+8"
    )
    private Date updateTime;
    private Byte isDeleted;

    public User1() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWeChart() {
        return weChart;
    }

    public void setWeChart(String weChart) {
        this.weChart = weChart;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getHighSchoolId() {
        return highSchoolId;
    }

    public void setHighSchoolId(Integer highSchoolId) {
        this.highSchoolId = highSchoolId;
    }

    public String getHighSchoolName() {
        return highSchoolName;
    }

    public void setHighSchoolName(String highSchoolName) {
        this.highSchoolName = highSchoolName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getScienceTypeId() {
        return scienceTypeId;
    }

    public void setScienceTypeId(Integer scienceTypeId) {
        this.scienceTypeId = scienceTypeId;
    }

    public Integer getVipLevelId() {
        return vipLevelId;
    }

    public void setVipLevelId(Integer vipLevelId) {
        this.vipLevelId = vipLevelId;
    }

    public Integer getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(Integer graduateYear) {
        this.graduateYear = graduateYear;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Byte getIfCompletedInformation() {
        return ifCompletedInformation;
    }

    public void setIfCompletedInformation(Byte ifCompletedInformation) {
        this.ifCompletedInformation = ifCompletedInformation;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", weChart='" + weChart + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", portrait='" + portrait + '\'' +
                ", provinceId=" + provinceId +
                ", provinceCode='" + provinceCode + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityId=" + cityId +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", districtId=" + districtId +
                ", districtCode='" + districtCode + '\'' +
                ", districtName='" + districtName + '\'' +
                ", highSchoolId=" + highSchoolId +
                ", highSchoolName='" + highSchoolName + '\'' +
                ", gradeName='" + gradeName + '\'' +
                ", className='" + className + '\'' +
                ", scienceTypeId='" + scienceTypeId + '\'' +
                ", vipLevelId=" + vipLevelId +
                ", graduateYear=" + graduateYear +
                ", growth=" + growth +
                ", integral=" + integral +
                ", ifCompletedInformation=" + ifCompletedInformation +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
