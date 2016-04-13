package com.dt.dtpt.mybatis.model.demo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "edu_school")
public class EduSchool implements Serializable {
    @Id
    @Column(name = "SCHOOL_ID")
    private String schoolId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AS_NAME")
    private String asName;

    @Column(name = "TEL_PHONE")
    private String telPhone;

    @Column(name = "MASTER")
    private String master;

    @Column(name = "MASTER_PHONE")
    private String masterPhone;

    @Column(name = "INFO")
    private String info;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EDIT_DATE")
    private Date editDate;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

    /**
     * @return SCHOOL_ID
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * @param schoolId
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return AS_NAME
     */
    public String getAsName() {
        return asName;
    }

    /**
     * @param asName
     */
    public void setAsName(String asName) {
        this.asName = asName;
    }

    /**
     * @return TEL_PHONE
     */
    public String getTelPhone() {
        return telPhone;
    }

    /**
     * @param telPhone
     */
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    /**
     * @return MASTER
     */
    public String getMaster() {
        return master;
    }

    /**
     * @param master
     */
    public void setMaster(String master) {
        this.master = master;
    }

    /**
     * @return MASTER_PHONE
     */
    public String getMasterPhone() {
        return masterPhone;
    }

    /**
     * @param masterPhone
     */
    public void setMasterPhone(String masterPhone) {
        this.masterPhone = masterPhone;
    }

    /**
     * @return INFO
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return ADDRESS
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return EDIT_DATE
     */
    public Date getEditDate() {
        return editDate;
    }

    /**
     * @param editDate
     */
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    /**
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return COMMON
     */
    public String getCommon() {
        return common;
    }

    /**
     * @param common
     */
    public void setCommon(String common) {
        this.common = common;
    }
}