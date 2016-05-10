package com.dt.dtpt.mybatis.model.publicwx;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Table(name = "wx_public")
public class WxPublic implements Serializable {
    /**
     * 公众号编号
     */
	@Id
    @Column(name = "PUBLIC_ID")
    private String publicId;

    /**
     * 用户编号
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 公众号名称
     */
    @Column(name = "PUBLIC_NAME")
    private String publicName;

    /**
     * 微信号
     */
    @Column(name = "WX_ACCOUNT")
    private String wxAccount;

    /**
     * 微信OPENID
     */
    @Column(name = "WX_OPENID")
    private String wxOpenid;

    /**
     * 类型
     */
    @Column(name = "PUBLIC_TYPE")
    private Integer publicType;

    /**
     * 认证通过否(0否1是)
     */
    @Column(name = "IS_APPLY")
    private Integer isApply;

    /**
     * 标识
     */
    @Column(name = "UNIQUE_CHAR")
    private String uniqueChar;

    /**
     * 加密串
     */
    @Column(name = "ENCRIY_CHAR")
    private String encriyChar;

    /**
     * 配置方案类型
     */
    @Column(name = "SOLUTION_TYPE")
    private Integer solutionType;

    /**
     * 是否本平台(0否1是)
     */
    @Column(name = "IS_SELF")
    private Integer isSelf;

    /**
     * 编辑时间
     */
    @Column(name = "EDIT_DATE")
    private Date editDate;

    /**
     * 备注
     */
    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

    /**
     * 获取公众号编号
     *
     * @return PUBLIC_ID - 公众号编号
     */
    public String getPublicId() {
        return publicId;
    }

    /**
     * 设置公众号编号
     *
     * @param publicId 公众号编号
     */
    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    /**
     * 获取用户编号
     *
     * @return USER_ID - 用户编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取公众号名称
     *
     * @return PUBLIC_NAME - 公众号名称
     */
    public String getPublicName() {
        return publicName;
    }

    /**
     * 设置公众号名称
     *
     * @param publicName 公众号名称
     */
    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    /**
     * 获取微信号
     *
     * @return WX_ACCOUNT - 微信号
     */
    public String getWxAccount() {
        return wxAccount;
    }

    /**
     * 设置微信号
     *
     * @param wxAccount 微信号
     */
    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

    /**
     * 获取微信OPENID
     *
     * @return WX_OPENID - 微信OPENID
     */
    public String getWxOpenid() {
        return wxOpenid;
    }

    /**
     * 设置微信OPENID
     *
     * @param wxOpenid 微信OPENID
     */
    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    /**
     * 获取类型
     *
     * @return PUBLIC_TYPE - 类型
     */
    public Integer getPublicType() {
        return publicType;
    }

    /**
     * 设置类型
     *
     * @param publicType 类型
     */
    public void setPublicType(Integer publicType) {
        this.publicType = publicType;
    }

    /**
     * 获取认证通过否(0否1是)
     *
     * @return IS_APPLY - 认证通过否(0否1是)
     */
    public Integer getIsApply() {
        return isApply;
    }

    /**
     * 设置认证通过否(0否1是)
     *
     * @param isApply 认证通过否(0否1是)
     */
    public void setIsApply(Integer isApply) {
        this.isApply = isApply;
    }

    /**
     * 获取标识
     *
     * @return UNIQUE_CHAR - 标识
     */
    public String getUniqueChar() {
        return uniqueChar;
    }

    /**
     * 设置标识
     *
     * @param uniqueChar 标识
     */
    public void setUniqueChar(String uniqueChar) {
        this.uniqueChar = uniqueChar;
    }

    /**
     * 获取加密串
     *
     * @return ENCRIY_CHAR - 加密串
     */
    public String getEncriyChar() {
        return encriyChar;
    }

    /**
     * 设置加密串
     *
     * @param encriyChar 加密串
     */
    public void setEncriyChar(String encriyChar) {
        this.encriyChar = encriyChar;
    }

    /**
     * 获取配置方案类型
     *
     * @return SOLUTION_TYPE - 配置方案类型
     */
    public Integer getSolutionType() {
        return solutionType;
    }

    /**
     * 设置配置方案类型
     *
     * @param solutionType 配置方案类型
     */
    public void setSolutionType(Integer solutionType) {
        this.solutionType = solutionType;
    }

    /**
     * 获取是否本平台(0否1是)
     *
     * @return IS_SELF - 是否本平台(0否1是)
     */
    public Integer getIsSelf() {
        return isSelf;
    }

    /**
     * 设置是否本平台(0否1是)
     *
     * @param isSelf 是否本平台(0否1是)
     */
    public void setIsSelf(Integer isSelf) {
        this.isSelf = isSelf;
    }

    /**
     * 获取编辑时间
     *
     * @return EDIT_DATE - 编辑时间
     */
    public Date getEditDate() {
        return editDate;
    }

    /**
     * 设置编辑时间
     *
     * @param editDate 编辑时间
     */
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    /**
     * 获取备注
     *
     * @return COMMON - 备注
     */
    public String getCommon() {
        return common;
    }

    /**
     * 设置备注
     *
     * @param common 备注
     */
    public void setCommon(String common) {
        this.common = common;
    }
}