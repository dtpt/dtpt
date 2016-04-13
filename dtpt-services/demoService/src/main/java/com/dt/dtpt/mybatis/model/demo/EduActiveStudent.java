package com.dt.dtpt.mybatis.model.demo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "edu_active_student")
public class EduActiveStudent implements Serializable {
    @Id
    @Column(name = "STUDENT_ACT_ID")
    private String studentActId;

    @Column(name = "ACTIVE_ID")
    private String activeId;

    @Column(name = "ACTIVE_TITLE")
    private String activeTitle;

    @Column(name = "ACTIVE_SUBJECT")
    private String activeSubject;

    @Column(name = "ACTIVE_SUBJECT_SUB")
    private String activeSubjectSub;

    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    /**
     * 0未缴费
            1已缴费
     */
    @Column(name = "IS_PAYED")
    private Integer isPayed;

    @Column(name = "PAY_DATE")
    private Date payDate;

    @Column(name = "PAY_JE")
    private BigDecimal payJe;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "EDIT_DATE")
    private Date editDate;

    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

    /**
     * @return STUDENT_ACT_ID
     */
    public String getStudentActId() {
        return studentActId;
    }

    /**
     * @param studentActId
     */
    public void setStudentActId(String studentActId) {
        this.studentActId = studentActId;
    }

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
     * @return STUDENT_ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return STUDENT_NAME
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 获取0未缴费
            1已缴费
     *
     * @return IS_PAYED - 0未缴费
            1已缴费
     */
    public Integer getIsPayed() {
        return isPayed;
    }

    /**
     * 设置0未缴费
            1已缴费
     *
     * @param isPayed 0未缴费
            1已缴费
     */
    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    /**
     * @return PAY_DATE
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * @param payDate
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * @return PAY_JE
     */
    public BigDecimal getPayJe() {
        return payJe;
    }

    /**
     * @param payJe
     */
    public void setPayJe(BigDecimal payJe) {
        this.payJe = payJe;
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