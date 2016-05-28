package com.dt.dtpt.service.sijiao;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.sijiao.EduCourse;
import com.dt.dtpt.mybatis.model.sijiao.EduStudent;
import com.dt.dtpt.util.Result;
@Service
@Path("/sijiao")
@Consumes({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
@Produces({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
public interface SijiaoService {
	
	//==================== WX interface ==================
	/**
	 * 是否为管理员
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @return 是返回对象的success属性为true，否则为false
	 */
	@GET
	@Path("/isWxManerger/{shId}/{userOpenID}")
	public Result isWxManerger(@PathParam("shId") String shId, @PathParam("userOpenID") String userOpenID);
	/**
	 * 用户获取课程列表
	 * @param shId 管理员用户编号，不能为空
	 * @param eduCourse 精准匹配的课程条件对象
	 * @param pageNumber 页码，不能为空
	 * @param pageSize 每页数据行数，不能为空
	 * @return 返回对象的success为true时，result属性为List<EduCourse>
	 */
	@POST
	@Path("/findWxCourses/{shId}/{pageNumber}/{pageSize}")
	public Result findWxCourses(@PathParam("shId") String shId, EduCourse eduCourse,
			@PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize);
	/**
	 * 新增课程
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @param course 需要添加的课程信息：课程名称、课程类型、老师姓名、学年、学期、开始日期、结束日期、上课时间、上课地点、节数、限制人数、课程内容
	 * @return 返回对象的success属性为true是，操作成功；否则操作失败
	 */
	@POST
	@Path("/addCourseByAdmin/{shId}/{userOpenID}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result addCourseByAdmin(@PathParam("shId") String shId, @PathParam("userOpenID") String userOpenID, EduCourse course);
	/**
	 * 获取用户下已添加学员
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @return 返回对象的success属性为true时，result属性为List<EduStudent>
	 */
	@GET
	@Path("/findEduStudents/{userOpenID}")
	public Result findEduStudents(@PathParam("userOpenID") String userOpenID);
	
	/**
	 * 添加学员
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @param eduStudent 需要添加的学员信息：姓名、手机、住址、出生年月、性别、学年级
	 * @return 返回对象的success属性值为true时，添加成功，result值为EduStudent对象；否则添加失败
	 */
	@POST
	@Path("/addStudentByWx/{shId}/{userOpenID}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result addStudentByWx(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID, EduStudent eduStudent);
	/**
	 * 学员添加课程
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @param courseId 需要添加的课程编号，不能为空
	 * @return 返回对象的success属性值为true时，添加成功,result值为courseSid(学员选课编号)；否则添加失败
	 */
	@POST
	@Path("/addCourseByWx/{userOpenID}/{courseId}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result addCourseByWx(@PathParam("userOpenID") String userOpenID, @PathParam("courseId") String courseId);
	/**
	 * 预付款确认课程详细信息
	 * @param courseId 课程编号，不能为空
	 * @return 返回对象的success属性值为true时，result属性为EduCourse
	 */
	@GET
	@Path("/getCourse/{courseId}")
	public Result getCourse(@PathParam("courseId") String courseId);
	/**
	 * 预付款确认学员信息
	 * @param studentId 学员编号，不能为空
	 * @return 返回对象的success属性值为true时，result属性为EduStudent
	 */
	@GET
	@Path("/getStudent/{studentId}")
	public Result getStudent(@PathParam("studentId") String studentId);
	/**
	 * 课程付款完成
	 * @param courseSid 学员选课编号(订单编号)，不能为空
	 * @param payJe 实际付款金额
	 * @return 返回对象的success属性值为true时，操作成功；否则操作失败
	 */
	@POST
	@Path("/payOk/{courseSid}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result payOk(@PathParam("courseSid") String courseSid,String payJe);
	
	/**
	 * 获取我已添加的课程
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @return 返回对象的success属性值为true时，result属性为List<com.dt.dtpt.vo.EduCourseStudentView>
	 */
	@GET
	@Path("/getMyCourse/{shId}/{userOpenID}")
	public Result getMyCourse(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID);
	/**
	 * 获取我已缴费的课程，学习历程接口
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @return 返回对象的success属性值为true时，result属性为List<com.dt.dtpt.vo.EduCourseStudentView>
	 */
	@GET
	@Path("/getMyCourse/{shId}/{userOpenID}")
	public Result getMyCourseForTime(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID);
	
	/**
	 * 根据已添加课程编号获取已添加课程信息
	 * @param courseSid 学员选课编号(订单编号)，不能为空
	 * @return 返回对象的success属性值为true时，result属性为com.dt.dtpt.vo.EduCourseStudentView
	 */
	@GET
	@Path("/getCourseSt/{shId}/{courseSid}")
	public Result getCourseSt(@PathParam("shId") String shId,@PathParam("courseSid") String courseSid);
	
	/**
	 * 判断是否可以付款，并置为订单状态为付款中
	 * @param courseSid 学员选课编号(订单编号)，不能为空
	 * @return 返回对象的success属性值为true时，可以付款；否则订单就是失效了，需要重新下单
	 */
	@GET
	@Path("/prePay/{courseSid}/{payId}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result prePay(@PathParam("courseSid") String courseSid, @PathParam("payId") String payId);
	
	/**
	 * 检测未缴费的单，并判断可报人数是否为预警成数，是则置为已失效，已报名人数  -1
	 * 假如最多可报20人，预警成数为 2/10，即预警数为4，此处该传参数2
	 */
	@GET
	@Path("/noPayhandler/{warnNum}")
	@Transactional(propagation = Propagation.REQUIRED)
	public void noPayhandler(@PathParam("warnNum") @DefaultValue("2") Integer warnNum);
	
	/**
	 * 未缴费超出指定天数的课程，置为失效，即使可报人数还很多
	 * @param offDay
	 */
	@GET
	@Path("/noPayHanderforDay/{offDay}")
	@Transactional(propagation = Propagation.REQUIRED)
	public void noPayHanderforDay(@PathParam("offDay") @DefaultValue("1") Integer offDay);
	//==================== WX interface ==================
}
