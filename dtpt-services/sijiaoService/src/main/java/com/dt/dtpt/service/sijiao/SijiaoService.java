package com.dt.dtpt.service.sijiao;

import com.dt.dtpt.mybatis.model.sijiao.EduCourse;
import com.dt.dtpt.mybatis.model.sijiao.EduStudent;
import com.dt.dtpt.util.Result;

public interface SijiaoService {
	
	//==================== WX interface ==================
	/**
	 * 是否为管理员
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @return 是返回对象的success属性为true，否则为false
	 */
	public Result isWxManerger(String shId,String userOpenID);
	/**
	 * 用户获取课程列表
	 * @param shId 管理员用户编号，不能为空
	 * @param eduCourse 精准匹配的课程条件对象
	 * @param pageNumber 页码，不能为空
	 * @param pageSize 每页数据行数，不能为空
	 * @return 返回对象的success为true时，result属性为List<EduCourse>
	 */
	public Result findWxCourses(String shId,EduCourse eduCourse,int pageNumber,int pageSize);
	/**
	 * 新增课程
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @param course 需要添加的课程信息：课程名称、课程类型、老师姓名、学年、学期、开始日期、结束日期、上课时间、上课地点、节数、限制人数、课程内容
	 * @return 返回对象的success属性为true是，操作成功；否则操作失败
	 */
	public Result addCourseByWx(String shId,String userOpenID,EduCourse course);
	/**
	 * 获取用户下已添加学员
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @return 返回对象的success属性为true时，result属性为List<EduStudent>
	 */
	public Result findEduStudents(String userOpenID);
	
	/**
	 * 添加学员
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @param eduStudent 需要添加的学员信息：姓名、手机、住址、出生年月、性别、学年级
	 * @return 返回对象的success属性值为true时，添加成功，result值为EduStudent对象；否则添加失败
	 */
	public Result addStudentByWx(String shId,String userOpenID,EduStudent eduStudent);
	/**
	 * 学员添加课程
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @param courseId 需要添加的课程编号，不能为空
	 * @return 返回对象的success属性值为true时，添加成功；否则添加失败
	 */
	public Result addCourseByWx(String userOpenID,String courseId);
	/**
	 * 预付款确认课程详细信息
	 * @param courseId 课程编号，不能为空
	 * @return 返回对象的success属性值为true时，result属性为EduCourse
	 */
	public Result getCourse(String courseId);
	/**
	 * 预付款确认学员信息
	 * @param studentId 学员编号，不能为空
	 * @return 返回对象的success属性值为true时，result属性为EduStudent
	 */
	public Result geStudent(String studentId);
	/**
	 * 课程付款完成
	 * @param courseSid 学员选课编号(订单编号)，不能为空
	 * @param payJe 实际付款金额
	 * @return 返回对象的success属性值为true时，操作成功；否则操作失败
	 */
	public Result payOk(String courseSid,String payJe);
	//==================== WX interface ==================
}
