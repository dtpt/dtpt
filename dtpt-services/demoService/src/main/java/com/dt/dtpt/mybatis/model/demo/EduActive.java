package com.dt.dtpt.mybatis.model.demo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "edu_active")
public class EduActive implements Serializable {
    @Id
    @Column(name = "ACTIVE_ID")
    private String activeId;

    @Column(name = "SCHOOL_ID")
    private String schoolId;

    @Column(name = "ACTIVE_TITLE")
    private String activeTitle;

    @Column(name = "ACTIVE_SUBJECT")
    private String activeSubject;

    @Column(name = "ACTIVE_SUBJECT_SUB")
    private String activeSubjectSub;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "LEADER")
    private String leader;

    @Column(name = "LEADER_PHONE")
    private String leaderPhone;

    @Column(name = "ACTIVE_INFO")
    private String activeInfo;

    @Column(name = "MAX_STUDENTS")
    private Integer maxStudents;

    @Column(name = "PUBLICER")
    private String publicer;

    @Column(name = "PUBLICER_AS_NAME")
    private String publicerAsName;

    @Column(name = "ACTIVE_JF")
    private BigDecimal activeJf;

    @Column(name = "PUBLIC_DATE")
    private Date publicDate;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "EDIT_DATE")
    private Date editDate;

    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

    /**
     * @return ACTIVE_ID
     */
    public String getActiveId() {
        return activeId;
    }

    /**
     * @param activeId
     */
    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

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
     * @return ACTIVE_TITLE
     */
    public String getActiveTitle() {
        return activeTitle;
    }

    /**
     * @param activeTitle
     */
    public void setActiveTitle(String activeTitle) {
        this.activeTitle = activeTitle;
    }

    /**
     * @return ACTIVE_SUBJECT
     */
    public String getActiveSubject() {
        return activeSubject;
    }

    /**
     * @param activeSubject
     */
    public void setActiveSubject(String activeSubject) {
        this.activeSubject = activeSubject;
    }

    /**
     * @return ACTIVE_SUBJECT_SUB
     */
    public String getActiveSubjectSub() {
        return activeSubjectSub;
    }

    /**
     * @param activeSubjectSub
     */
    public void setActiveSubjectSub(String activeSubjectSub) {
        this.activeSubjectSub = activeSubjectSub;
    }

    /**
     * @return START_DATE
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return END_DATE
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
     * @return LEADER
     */
    public String getLeader() {
        return leader;
    }

    /**
     * @param leader
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * @return LEADER_PHONE
     */
    public String getLeaderPhone() {
        return leaderPhone;
    }

    /**
     * @param leaderPhone
     */
    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone;
    }

    /**
     * @return ACTIVE_INFO
     */
    public String getActiveInfo() {
        return activeInfo;
    }

    /**
     * @param activeInfo
     */
    public void setActiveInfo(String activeInfo) {
        this.activeInfo = activeInfo;
    }

    /**
     * @return MAX_STUDENTS
     */
    public Integer getMaxStudents() {
        return maxStudents;
    }

    /**
     * @param maxStudents
     */
    public void setMaxStudents(Integer maxStudents) {
        this.maxStudents = maxStudents;
    }

    /**
     * @return PUBLICER
     */
    public String getPublicer() {
        return publicer;
    }

    /**
     * @param publicer
     */
    public void setPublicer(String publicer) {
        this.publicer = publicer;
    }

    /**
     * @return PUBLICER_AS_NAME
     */
    public String getPublicerAsName() {
        return publicerAsName;
    }

    /**
     * @param publicerAsName
     */
    public void setPublicerAsName(String publicerAsName) {
        this.publicerAsName = publicerAsName;
    }

    /**
     * @return ACTIVE_JF
     */
    public BigDecimal getActiveJf() {
        return activeJf;
    }

    /**
     * @param activeJf
     */
    public void setActiveJf(BigDecimal activeJf) {
        this.activeJf = activeJf;
    }

    /**
     * @return PUBLIC_DATE
     */
    public Date getPublicDate() {
        return publicDate;
    }

    /**
     * @param publicDate
     */
    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
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