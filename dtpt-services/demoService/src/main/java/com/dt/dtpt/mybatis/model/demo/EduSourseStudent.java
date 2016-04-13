package com.dt.dtpt.mybatis.model.demo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "edu_sourse_student")
public class EduSourseStudent implements Serializable {
    @Id
    @Column(name = "COURSE_SID")
    private String courseSid;

    @Column(name = "COURSE_ID")
    private String courseId;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "SUBJECT_SUB")
    private String subjectSub;

    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

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
     * @return COURSE_SID
     */
    public String getCourseSid() {
        return courseSid;
    }

    /**
     * @param courseSid
     */
    public void setCourseSid(String courseSid) {
        this.courseSid = courseSid;
    }

    /**
     * @return COURSE_ID
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @return COURSE_NAME
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return SUBJECT
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return SUBJECT_SUB
     */
    public String getSubjectSub() {
        return subjectSub;
    }

    /**
     * @param subjectSub
     */
    public void setSubjectSub(String subjectSub) {
        this.subjectSub = subjectSub;
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
     * @return IS_PAYED
     */
    public Integer getIsPayed() {
        return isPayed;
    }

    /**
     * @param isPayed
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