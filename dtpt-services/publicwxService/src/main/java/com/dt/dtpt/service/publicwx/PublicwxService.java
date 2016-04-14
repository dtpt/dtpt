package com.dt.dtpt.service.publicwx;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.publicwx.WxUserPublic;
import com.dt.dtpt.util.Result;
@Service
@Path("/publicwx/{shId}")
@Consumes({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
@Produces({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
public interface PublicwxService {

	/**
	 * 根据商户编号获取公众号信息
	 * @param shId 商户的用户编号，不能为空
	 * @return 返回对象中的result属性为WxPublic对象
	 */
	@GET
	public Result getWxPublicByShid(@PathParam("shId") String shId);
	
	/**
	 * 判断用户是否为商户管理员
	 * @param userOpenID 用户微信OPENID，不能为空
	 * @param shId 商户的用户编号，不能为空
	 * @return 是则返回对象的success属性值为true,否则为false
	 */
	@GET
	@Path("/isManerger/{userOpenID}")
	public Result isManerger(@PathParam("userOpenID") String userOpenID, @PathParam("shId") String shId);
	
	/**
	 * 用户关注公众号
	 * @param wxUserPublic 微信用户对象,微信OPENID不能为空，希望微信UnionID能不为空
	 * @param shId 商户编号
	 * @return 记录成功，返回对象的success属性为true,否则为false
	 */
	@POST
	@Path("/attentionPublic")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result attentionPublic(WxUserPublic wxUserPublic, @PathParam("shId") String shId);
}
