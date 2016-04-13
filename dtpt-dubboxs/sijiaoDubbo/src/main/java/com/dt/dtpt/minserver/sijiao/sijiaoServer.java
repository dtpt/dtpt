package com.dt.dtpt.minserver.sijiao;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

@Path("sijiao")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class sijiaoServer {

	//是否为管理员
	@GET
    @Path("{shPublicId/userWxzh}")
	public boolean isManerger(@PathParam("shPublicId") String shPublicId,@PathParam("shPublicId") String userWxzh, @Context HttpServletRequest request){
		boolean is = false;
		return is;
	}
	//获取课程列表
	//新增课程列表
	//添加学员
}
