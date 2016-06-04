package com.dt.dtpt.service.publicwx.impl;

import java.util.Date;
import java.util.List;
import com.dt.dtpt.util.UUID;

import javax.ws.rs.PathParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.publicwx.WxPublic;
import com.dt.dtpt.mybatis.model.publicwx.WxUserPublic;
import com.dt.dtpt.service.impl.WxPublicService;
import com.dt.dtpt.service.impl.WxUserPublicService;
import com.dt.dtpt.service.publicwx.PublicwxService;
import com.dt.dtpt.util.Result;
@Service
@Transactional(readOnly = true)
public class PublicwxServiceImpl implements PublicwxService {

	protected transient final Log log = LogFactory.getLog(PublicwxServiceImpl.class);
	
	@Autowired
	WxPublicService wxpublicService;
	
	@Autowired
	WxUserPublicService wxuserPublicService;
	
	public Result getWxPublicByShid(@PathParam("shId") String shId) {
		if(shId != null && !"".equals(shId)){
			WxPublic wxPublic = new WxPublic();
			wxPublic.setUserId(shId);
			List<WxPublic> wxPublics = wxpublicService.select(wxPublic);
			wxPublic  = null;
			if(wxPublics != null && wxPublics.size() > 0) wxPublic = wxPublics.get(0);
			return Result.success(wxPublic);
		}else{
			return Result.failure("参数校验失败", "商户的编号为空");
		}
	}

	public Result isManerger(@PathParam("userOpenID") String userOpenID, @PathParam("shId") String shId) {
		if(userOpenID != null && !"".equals(userOpenID) && shId != null && !"".equals(shId)){
			WxPublic wxPublic = (WxPublic) this.getWxPublicByShid(shId).getResult();
			if(wxPublic != null && wxPublic.getWxOpenid() != null && wxPublic.getWxOpenid().contains(userOpenID)){
				return Result.success();
			}else{
				return Result.failure("操作用户账号非该商户管理员账号");
			}
		}else{
			return Result.failure("参数校验失败", "商户的编号或用户微信账号为空");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Result attentionPublic(WxUserPublic wxUserPublic, @PathParam("shId") String shId) {
		log.error("=====0============");
		if(shId != null && !"".equals(shId) && wxUserPublic != null && wxUserPublic.getWxOpenid() != null 
				&& !"".equals(wxUserPublic.getWxOpenid())){
			WxPublic wxPublic = new WxPublic();
			wxPublic.setUserId(shId);
			List<WxPublic> wxPublics = wxpublicService.select(wxPublic);
			wxPublic  = null;
			String res = "";
			log.error("=====1============");
			if(wxPublics != null && wxPublics.size() > 0){
				wxPublic = wxPublics.get(0);
				WxUserPublic wup = new WxUserPublic();
				wup.setPublicId(wxPublic.getPublicId());
				wup.setWxOpenid(wxUserPublic.getWxOpenid());
				log.error("=====2============");
				wup = wxuserPublicService.selectOne(wup);
				Date date = new Date();
				wxUserPublic.setAddDate(date);
				wxUserPublic.setPublicId(wxPublic.getPublicId());
				int rs = 0;
				if(wup != null){
					log.error("=====3============");
					wxUserPublic.setUserPwxId(wup.getUserPwxId());
					rs = wxuserPublicService.updateAll(wxUserPublic);
				}else{
					log.error("=====4============");
					wxUserPublic.setUserPwxId(UUID.randomUUID().toString());
					rs = wxuserPublicService.save(wxUserPublic);
				}
				log.error("=====5============");
				if(rs > 0) return Result.success();
				res = "更新数据库失败";
			}else{
				res = "未查找到对应公众号信息";
			} 
			log.error("=====6============");
			return Result.failure("关注失败",res);
		}else{
			log.error("=====7============");
			return Result.failure("参数校验失败", "商户编号或用户微信openID为空");
		}
	}

	public void setWxpublicService(WxPublicService wxpublicService) {
		this.wxpublicService = wxpublicService;
	}

	public void setWxuserPublicService(WxUserPublicService wxuserPublicService) {
		this.wxuserPublicService = wxuserPublicService;
	}

	public PublicwxServiceImpl() {
		super();
	}

	
}
