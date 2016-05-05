package com.dt.dtpt.service.sijiao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.sijiao.EduCourse;
import com.dt.dtpt.mybatis.model.sijiao.EduCourseStudent;
import com.dt.dtpt.mybatis.model.sijiao.EduStudent;
import com.dt.dtpt.mybatis.model.sijiao.EduTeacher;
import com.dt.dtpt.service.impl.EduCourseService;
import com.dt.dtpt.service.impl.EduCourseStudentService;
import com.dt.dtpt.service.impl.EduStudentService;
import com.dt.dtpt.service.impl.EduTeacherService;
import com.dt.dtpt.service.publicwx.PublicwxService;
import com.dt.dtpt.service.sijiao.SijiaoService;
import com.dt.dtpt.util.Result;

@Service
@Transactional(readOnly = true)
public class SijiaoServiceImpl implements SijiaoService {

	@Autowired
	EduCourseService eduCourseService;
	
	@Autowired
	EduTeacherService eduTeacherService;
	
	@Autowired
	EduStudentService eduStudentService;
	
	@Autowired
	EduCourseStudentService eduCourseStudentService;
	
	@Autowired
	PublicwxService publicwxService;
	
	public Result isWxManerger(@PathParam("shId") String shId, @PathParam("userOpenID") String userOpenID) {
		return publicwxService.isManerger(userOpenID, shId);
	}

	public Result findWxCourses(@PathParam("shId") String shId, EduCourse eduCourse,
			@PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
		if(shId != null && !"".equals(shId)){
			if(eduCourse == null) eduCourse = new EduCourse();
			eduCourse.setUserId(shId);
			return Result.success(eduCourseService.queryList(eduCourse, pageNumber, pageSize));
		}else{
			return Result.failure("参数校验失败", "商户编号为空");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@SuppressWarnings("deprecation")
	public Result addCourseByWx(@PathParam("shId") String shId, @PathParam("userOpenID") String userOpenID, EduCourse course) {
		if(isWxManerger(shId, userOpenID).isSuccess()){
			if(course != null && course.getCourseName() != null && !"".equals(course.getCourseName())
					&& course.getSubjectSub() != null && !"".equals(course.getSubjectSub())
					&& course.getTeacherName() != null && !"".equals(course.getTeacherName())
					&& course.getSemester() != null && course.getStartDate() != null
					&& course.getEndDate() != null && course.getTeachTime() != null
					&& course.getTeachAddress() != null && !"".equals(course.getTeachAddress())
					&& course.getTotalCourse() != null && course.getMaxStudents() != null
					&& course.getCourseInfo() != null && !"".equals(course.getCourseInfo())){	
				Date date = new Date();
				EduTeacher teacher=new EduTeacher();
				teacher.setTeacherName(course.getTeacherName());
				List<EduTeacher> teachers = eduTeacherService.select(teacher);
				String teacherId = null;
				if(teachers != null && teachers.size() > 0){
					teacherId = teachers.get(0).getTeacherId();
				}else{
					teacherId = UUID.randomUUID().toString();
					teacher.setTeacherId(teacherId);
					teacher.setEditDate(date);
					teacher.setUserId(shId);
					int rs = eduTeacherService.save(teacher);
					if(rs < 1) teacherId = null;
				}
				course.setTeacherId(teacherId);
				course.setCourseId(UUID.randomUUID().toString());
				course.setEditDate(date);
				course.setPayStudents(0);
				course.setSubject("1");
				course.setYear(date.getYear() + "");
				course.setUserId(shId);
				int rs = eduCourseService.save(course);
				if(rs>0) {
					return Result.success();
				}
				return Result.failure("课程添加失败");
			}else{
				return Result.failure("参数校验失败", "需要添加的课程为空或某些必要内容为空");
			}
		}else{
			return Result.failure("参数校验失败", "操作的用户非管理员");
		}
	}

	public Result findEduStudents(@PathParam("userOpenID") String userOpenID) {
		if(userOpenID != null && !"".equals(userOpenID)){
			EduStudent student = new EduStudent();
			student.setWxOpenid(userOpenID);
			List<EduStudent> students = eduStudentService.select(student);
			return Result.success(students);
		}else{
			return Result.failure("参数校验失败","用户微信OPENID为空");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Result addStudentByWx(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID, EduStudent eduStudent) {
		if(userOpenID != null && !"".equals(userOpenID)){
			if(eduStudent != null && eduStudent.getStudentName() != null && !"".equals(eduStudent.getStudentName())
					&& eduStudent.getPhone() != null && !"".equals(eduStudent.getPhone())
					&& eduStudent.getAddress() != null && !"".equals(eduStudent.getAddress())
					&& eduStudent.getBirthday() != null && eduStudent.getSex() != null 
					&& eduStudent.getInGrade() != null){
				Date date = new Date();
				eduStudent.setEditDate(date);
				eduStudent.setWxOpenid(userOpenID);
				eduStudent.setStudentId(UUID.randomUUID().toString());
				eduStudent.setUserId(shId);
				int rs = eduStudentService.save(eduStudent);
				if(rs > 0) return Result.success(eduStudent);
				return Result.failure("添加学员失败");
			}else{				
				return Result.failure("参数校验失败","需要添加的学生对象为空或某些必填内容为空");
			}
		}else{
			return Result.failure("参数校验失败","用户微信OPENID为空");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Result addCourseByWx(@PathParam("userOpenID") String userOpenID, @PathParam("courseId") String courseId) {
		if(userOpenID != null && !"".equals(userOpenID) && courseId != null && !"".equals(courseId)){
			EduStudent eduStudent = new EduStudent();
			eduStudent.setWxOpenid(userOpenID);
			List<EduStudent> students = eduStudentService.select(eduStudent);
			if(students != null && students.size() > 0){
				eduStudent = students.get(0);
			}else{
				return Result.failure("此微信下面还没有学员");
			}
			EduCourse course = new EduCourse();
			course.setCourseId(courseId);
			course = eduCourseService.selectOne(course);
			if(course != null){
				Date date = new Date();
				EduCourseStudent cs = new EduCourseStudent();
				cs.setCourseId(courseId);
				cs.setCourseName(course.getCourseName());
				cs.setCourseSid(UUID.randomUUID().toString());
				cs.setEditDate(date);
				cs.setIsPayed(0);
				cs.setStudentId(eduStudent.getStudentId());
				cs.setStudentName(eduStudent.getStudentName());
				cs.setSubject(course.getSubject());
				cs.setSubjectSub(course.getSubjectSub());
				cs.setUserId(course.getUserId());
				int rs = eduCourseStudentService.save(cs);
				if(rs > 0) return Result.success();
			}else{
				return Result.failure("系统中未查到该课程");
			}
			return Result.failure("添加学员失败");
		}else{
			return Result.failure("参数校验失败","用户微信OPENID或课程编号为空");
		}
	}

	public Result getCourse(@PathParam("courseId") String courseId) {
		if(courseId != null && !"".equals(courseId)){
			EduCourse course = new EduCourse();
			course.setCourseId(courseId);
			course = eduCourseService.selectOne(course);
			return Result.success(course);
		}else{
			return Result.failure("参数校验失败","课程编号为空");
		}
	}

	public Result getStudent(@PathParam("studentId") String studentId) {
		if(studentId != null && !"".equals(studentId)){
			EduStudent student = new EduStudent();
			student.setStudentId(studentId);
			student = eduStudentService.selectOne(student);
			return Result.success(student);
		}else{
			return Result.failure("参数校验失败","学员编号为空");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Result payOk(@PathParam("courseSid") String courseSid,String payJe) {
		if(courseSid != null && !"".equals(courseSid) && payJe != null && !"".equals(payJe)){
			EduCourseStudent cs = new EduCourseStudent();
			cs.setCourseSid(courseSid);
			cs = eduCourseStudentService.selectOne(cs);
			if(cs != null){
				if(cs.getIsPayed() < 1){
					cs.setIsPayed(1);
					cs.setPayJe(BigDecimal.valueOf(Double.valueOf(payJe)));
					cs.setPayDate(new Date());
					int rs = eduCourseStudentService.updateNotNull(cs);
					if(rs < 1) Result.failure("付款状态修改失败");
				}
				return Result.success();
			}
			return Result.failure("系统中未查到该学员选课信息");
		}else{
			return Result.failure("参数校验失败","学员选课编号或付款金额为空");
		}
	}

	public Result getMyCourse(String shId, String userOpenID) {
		if(userOpenID != null && !"".equals(userOpenID) && shId != null && !"".equals(shId)){
			EduStudent student = new EduStudent();
			student.setWxOpenid(userOpenID);
			List<EduStudent> students = eduStudentService.select(student);
			List<EduCourseStudent> ecs = new ArrayList<EduCourseStudent>();
			if(students != null && students.size() > 0){
				EduCourseStudent eCourseStudent = new EduCourseStudent();
				eCourseStudent.setUserId(shId);
				eCourseStudent.setStudentId(students.get(0).getStudentId());
				ecs = eduCourseStudentService.select(eCourseStudent);
			}
			return Result.success(ecs);
		}else{
			return Result.failure("参数校验失败","用户微信OPENID或商户ID为空");
		}
	}

}
