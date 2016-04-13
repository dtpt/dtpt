package com.dt.dtpt.mybatis.model.demo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "edu_school_photos")
public class EduSchoolPhotos implements Serializable {
    @Id
    @Column(name = "PHOTO_ID")
    private String photoId;

    @Column(name = "PHOTO_NAME")
    private String photoName;

    @Column(name = "PHOTO_INFO")
    private String photoInfo;

    @Column(name = "SOURCE_ID")
    private String sourceId;

    @Column(name = "SOURCE_NAME")
    private String sourceName;

    @Column(name = "ACTIVE_ID")
    private String activeId;

    @Column(name = "ACTIVE_NAME")
    private String activeName;

    @Column(name = "PHOTO_PICS")
    private String photoPics;

    @Column(name = "PHOTO_NAMES")
    private String photoNames;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "EDIT_DATE")
    private Date editDate;

    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

    /**
     * @return PHOTO_ID
     */
    public String getPhotoId() {
        return photoId;
    }

    /**
     * @param photoId
     */
    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    /**
     * @return PHOTO_NAME
     */
    public String getPhotoName() {
        return photoName;
    }

    /**
     * @param photoName
     */
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    /**
     * @return PHOTO_INFO
     */
    public String getPhotoInfo() {
        return photoInfo;
    }

    /**
     * @param photoInfo
     */
    public void setPhotoInfo(String photoInfo) {
        this.photoInfo = photoInfo;
    }

    /**
     * @return SOURCE_ID
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * @param sourceId
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * @return SOURCE_NAME
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * @param sourceName
     */
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
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
     * @return ACTIVE_NAME
     */
    public String getActiveName() {
        return activeName;
    }

    /**
     * @param activeName
     */
    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    /**
     * @return PHOTO_PICS
     */
    public String getPhotoPics() {
        return photoPics;
    }

    /**
     * @param photoPics
     */
    public void setPhotoPics(String photoPics) {
        this.photoPics = photoPics;
    }

    /**
     * @return PHOTO_NAMES
     */
    public String getPhotoNames() {
        return photoNames;
    }

    /**
     * @param photoNames
     */
    public void setPhotoNames(String photoNames) {
        this.photoNames = photoNames;
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