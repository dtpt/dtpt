package com.dt.dtpt.mybatis.model.demo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "edu_student")
public class EduStudent implements Serializable {
    @Id
    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "SEX")
    private Integer sex;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "IS_INSCHOOL")
    private Integer isInschool;

    @Column(name = "IN_GRADE")
    private Integer inGrade;

    @Column(name = "IN_SCHOOL")
    private String inSchool;

    @Column(name = "IN_SCORE")
    private String inScore;

    @Column(name = "HIGHEST_EDU")
    private Integer highestEdu;

    @Column(name = "QQ")
    private Integer qq;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "CITY")
    private String city;

    @Column(name = "AREA")
    private String area;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "EDIT_DATE")
    private Date editDate;

    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

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
     * @return IS_INSCHOOL
     */
    public Integer getIsInschool() {
        return isInschool;
    }

    /**
     * @param isInschool
     */
    public void setIsInschool(Integer isInschool) {
        this.isInschool = isInschool;
    }

    /**
     * @return IN_GRADE
     */
    public Integer getInGrade() {
        return inGrade;
    }

    /**
     * @param inGrade
     */
    public void setInGrade(Integer inGrade) {
        this.inGrade = inGrade;
    }

    /**
     * @return IN_SCHOOL
     */
    public String getInSchool() {
        return inSchool;
    }

    /**
     * @param inSchool
     */
    public void setInSchool(String inSchool) {
        this.inSchool = inSchool;
    }

    /**
     * @return IN_SCORE
     */
    public String getInScore() {
        return inScore;
    }

    /**
     * @param inScore
     */
    public void setInScore(String inScore) {
        this.inScore = inScore;
    }

    /**
     * @return HIGHEST_EDU
     */
    public Integer getHighestEdu() {
        return highestEdu;
    }

    /**
     * @param highestEdu
     */
    public void setHighestEdu(Integer highestEdu) {
        this.highestEdu = highestEdu;
    }

    /**
     * @return QQ
     */
    public Integer getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(Integer qq) {
        this.qq = qq;
    }

    /**
     * @return PROVINCE
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return CITY
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return AREA
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
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
     * @return ZIP_CODE
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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