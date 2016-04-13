package com.dt.dtpt.mybatis.model.demo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "edu_teacher")
public class EduTeacher implements Serializable {
    @Id
    @Column(name = "TEACHER_ID")
    private String teacherId;

    @Column(name = "SCHOOL_ID")
    private String schoolId;

    @Column(name = "TEACHER_NAME")
    private String teacherName;

    @Column(name = "SEX")
    private Integer sex;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PHONE")
    private String phone;

    /**
     * 教师、助教、教授、专家
     */
    @Column(name = "TEACHER_GRADE")
    private String teacherGrade;

    @Column(name = "TEACHER_INFO")
    private String teacherInfo;

    @Column(name = "EDIT_DATE")
    private Date editDate;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

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
     * @return SEX
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return AGE
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return PHONE
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取教师、助教、教授、专家
     *
     * @return TEACHER_GRADE - 教师、助教、教授、专家
     */
    public String getTeacherGrade() {
        return teacherGrade;
    }

    /**
     * 设置教师、助教、教授、专家
     *
     * @param teacherGrade 教师、助教、教授、专家
     */
    public void setTeacherGrade(String teacherGrade) {
        this.teacherGrade = teacherGrade;
    }

    /**
     * @return TEACHER_INFO
     */
    public String getTeacherInfo() {
        return teacherInfo;
    }

    /**
     * @param teacherInfo
     */
    public void setTeacherInfo(String teacherInfo) {
        this.teacherInfo = teacherInfo;
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