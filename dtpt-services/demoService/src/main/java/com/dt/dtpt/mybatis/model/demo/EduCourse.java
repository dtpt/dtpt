package com.dt.dtpt.mybatis.model.demo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "edu_course")
public class EduCourse implements Serializable {
    @Id
    @Column(name = "COURSE_ID")
    private String courseId;

    @Column(name = "SCHOOL_ID")
    private String schoolId;

    @Column(name = "COURSE_NAME")
    private String courseName;

    /**
     * 书法
     */
    @Column(name = "SUBJECT")
    private String subject;

    /**
     * 毛笔
            硬笔
            ...
     */
    @Column(name = "SUBJECT_SUB")
    private String subjectSub;

    @Column(name = "YEAR")
    private String year;

    /**
     * 春季班
            暑假班
            秋季班
            寒假班
     */
    @Column(name = "SEMESTER")
    private Integer semester;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "TEACHER_ID")
    private String teacherId;

    @Column(name = "TEACHER_NAME")
    private String teacherName;

    @Column(name = "TEACHER_PHONE")
    private String teacherPhone;

    @Column(name = "TOTAL_COURSE")
    private Integer totalCourse;

    @Column(name = "TEACH_TIME")
    private String teachTime;

    @Column(name = "TEACH_ADDRESS")
    private String teachAddress;

    @Column(name = "COURSE_INFO")
    private String courseInfo;

    @Column(name = "MAX_STUDENTS")
    private Integer maxStudents;

    @Column(name = "PAY_STUDENTS")
    private Integer payStudents;

    @Column(name = "COURSE_JE")
    private BigDecimal courseJe;

    @Column(name = "EDIT_DATE")
    private Date editDate;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

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
     * 获取书法
     *
     * @return SUBJECT - 书法
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置书法
     *
     * @param subject 书法
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 获取毛笔
            硬笔
            ...
     *
     * @return SUBJECT_SUB - 毛笔
            硬笔
            ...
     */
    public String getSubjectSub() {
        return subjectSub;
    }

    /**
     * 设置毛笔
            硬笔
            ...
     *
     * @param subjectSub 毛笔
            硬笔
            ...
     */
    public void setSubjectSub(String subjectSub) {
        this.subjectSub = subjectSub;
    }

    /**
     * @return YEAR
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取春季班
            暑假班
            秋季班
            寒假班
     *
     * @return SEMESTER - 春季班
            暑假班
            秋季班
            寒假班
     */
    public Integer getSemester() {
        return semester;
    }

    /**
     * 设置春季班
            暑假班
            秋季班
            寒假班
     *
     * @param semester 春季班
            暑假班
            秋季班
            寒假班
     */
    public void setSemester(Integer semester) {
        this.semester = semester;
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
     * @return TEACHER_ID
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * @param teacherId
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * @return TEACHER_NAME
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return TEACHER_PHONE
     */
    public String getTeacherPhone() {
        return teacherPhone;
    }

    /**
     * @param teacherPhone
     */
    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    /**
     * @return TOTAL_COURSE
     */
    public Integer getTotalCourse() {
        return totalCourse;
    }

    /**
     * @param totalCourse
     */
    public void setTotalCourse(Integer totalCourse) {
        this.totalCourse = totalCourse;
    }

    /**
     * @return TEACH_TIME
     */
    public String getTeachTime() {
        return teachTime;
    }

    /**
     * @param teachTime
     */
    public void setTeachTime(String teachTime) {
        this.teachTime = teachTime;
    }

    /**
     * @return TEACH_ADDRESS
     */
    public String getTeachAddress() {
        return teachAddress;
    }

    /**
     * @param teachAddress
     */
    public void setTeachAddress(String teachAddress) {
        this.teachAddress = teachAddress;
    }

    /**
     * @return COURSE_INFO
     */
    public String getCourseInfo() {
        return courseInfo;
    }

    /**
     * @param courseInfo
     */
    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
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
     * @return PAY_STUDENTS
     */
    public Integer getPayStudents() {
        return payStudents;
    }

    /**
     * @param payStudents
     */
    public void setPayStudents(Integer payStudents) {
        this.payStudents = payStudents;
    }

    /**
     * @return COURSE_JE
     */
    public BigDecimal getCourseJe() {
        return courseJe;
    }

    /**
     * @param courseJe
     */
    public void setCourseJe(BigDecimal courseJe) {
        this.courseJe = courseJe;
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