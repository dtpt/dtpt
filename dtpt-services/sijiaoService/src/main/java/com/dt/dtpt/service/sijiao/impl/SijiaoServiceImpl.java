package com.dt.dtpt.service.sijiao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dt.dtpt.util.UUID;

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
import com.dt.dtpt.vo.EduCourseStudentView;

@Service
@Transactional(readOnly = true)
public class SijiaoServiceImpl implements SijiaoService {

	public static Map<String, List<EduCourse>> shCourses = new HashMap<String, List<EduCourse>>();
	
	public static Map<String, Long> sysnTimes = new HashMap<String, Long>();
	
	public static final Long sysnTime = 5 * 60 * 1000l;
	
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
	
	private void reloadShCourses(String shId){
		if(shCourses.containsKey(shId)) shCourses.remove(shId);
		if(sysnTimes.containsKey(shId)) sysnTimes.remove(shId);
		this.sysnShCourses(shId);
	}
	
	private void updateCoursePaynum(String shId,String courseId,int num){
		if(shCourses.containsKey(shId)){
			for(EduCourse ec:shCourses.get(shId)){
				if(ec.getCourseId().equals(courseId)){
					int paynum = ec.getPayStudents() + num;
					if(paynum<0) paynum = 0;
					if(paynum>ec.getMaxStudents()) paynum = ec.getMaxStudents();
					ec.setPayStudents(paynum);
					break;
				}
			}
		}else{
			this.reloadShCourses(shId);
		}
	}
	
	private void addShCourses(String shId,EduCourse eduCourse){
		if(shCourses.containsKey(shId)){
			shCourses.get(shId).add(eduCourse);
		}else{
			this.reloadShCourses(shId);
		}
	}
	
	private List<EduCourse> sysnShCourses(String shId){
		List<EduCourse> ecs = null;
		if(shCourses.containsKey(shId)){
			Long st = sysnTimes.get(shId);
			if(new Date().getTime() - st > sysnTime){
				shCourses.put(shId, null);
				EduCourse eduCourse = new EduCourse();
				eduCourse.setUserId(shId);
				shCourses.put(shId, eduCourseService.select(eduCourse));
				sysnTimes.put(shId, new Date().getTime());
			}
		}else{
			EduCourse eduCourse = new EduCourse();
			eduCourse.setUserId(shId);
			shCourses.put(shId, eduCourseService.select(eduCourse));
			sysnTimes.put(shId, new Date().getTime());
		}
		ecs = shCourses.get(shId);
		return ecs;
	}
	
	public Result isWxManerger(@PathParam("shId") String shId, @PathParam("userOpenID") String userOpenID) {
		return publicwxService.isManerger(userOpenID, shId);
	}

	public Result findWxCourses(@PathParam("shId") String shId, EduCourse eduCourse,
			@PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
		if(shId != null && !"".equals(shId)){
			List<EduCourse> ecs = sysnShCourses(shId);
			int total = ecs.size();
			int start = (pageNumber-1) * pageSize;
			if(start < 0) start = 0;
			int end = pageNumber * pageSize;
			if(start >= total) ecs = new ArrayList<EduCourse>();
			if(end > total) end = total;
			if(start > end) end = start;
			ecs = ecs.subList(start, end);
			return Result.success(ecs);
		}else{
			return Result.failure("参数校验失败", "商户编号为空");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@SuppressWarnings("deprecation")
	public Result addCourseByAdmin(@PathParam("shId") String shId, @PathParam("userOpenID") String userOpenID, EduCourse course) {
		if(isWxManerger(shId, userOpenID).isSuccess()){
			if(course != null && course.getCourseName() != null && !"".equals(course.getCourseName())
					&& course.getSubjectSub() != null && !"".equals(course.getSubjectSub())
					&& course.getTeacherName() != null && !"".equals(course.getTeacherName())
					&& course.getSemester() != null && course.getStartDate() != null
					&& course.getEndDate() != null && course.getTeachTime() != null
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
				course.setYear((date.getYear()+1900) + "");
				course.setUserId(shId);
				int rs = eduCourseService.save(course);
				if(rs>0) {
					addShCourses(shId, course);
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
			EduCourseStudent qcs = new EduCourseStudent();
			qcs.setCourseId(courseId);
			qcs.setStudentId(eduStudent.getStudentId());
			qcs.setIsPayed(0);
			List<EduCourseStudent> qcses = eduCourseStudentService.select(qcs);
			if(qcses != null && qcses.size() > 0) return new Result(true,"该课程您已经添加",null,qcses.get(0).getCourseSid());
			EduCourse course = new EduCourse();
			course.setCourseId(courseId);
			course = eduCourseService.selectOne(course);
			if(course != null){
				if(course.getMaxStudents() - course.getPayStudents() < 1){
					return Result.failure("该班级已报满");
				}
				String sql = "update edu_course ec set ec.PAY_STUDENTS=ec.PAY_STUDENTS + 1 where ec.COURSE_ID=? and ec.PAY_STUDENTS<ec.MAX_STUDENTS";
				int rs = eduCourseService.getJdbcTemplate().update(sql, new Object[]{courseId});
				if(rs < 1) return Result.failure("该班级已报满");
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
				rs = eduCourseStudentService.save(cs);
				this.updateCoursePaynum(course.getUserId(), courseId, 1);
				if(rs > 0) return new Result(true,null,null,cs.getCourseSid());
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
					if(rs < 1) return Result.failure("付款状态修改失败");
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
			List<EduCourseStudentView> ecsvs = new ArrayList<EduCourseStudentView>();
			List<EduCourse> cs = shCourses.get(shId);
			Map<String, EduCourse> cMap = new HashMap<String, EduCourse>();
			for(EduCourse ec:cs){
				cMap.put(ec.getCourseId(), ec);
			}
			for(EduCourseStudent es : ecs){
				EduCourseStudentView ecsv = new EduCourseStudentView();
				ecsv.setEduCourse(cMap.get(es.getCourseId()));
				ecsv.setEduCourseStudent(es);
				ecsvs.add(ecsv);
			}
			return Result.success(ecsvs);
		}else{
			return Result.failure("参数校验失败","用户微信OPENID或商户ID为空");
		}
	}

	public Result getMyCourseForTime(String shId, String userOpenID) {
		if(userOpenID != null && !"".equals(userOpenID) && shId != null && !"".equals(shId)){
			EduStudent student = new EduStudent();
			student.setWxOpenid(userOpenID);
			List<EduStudent> students = eduStudentService.select(student);
			List<EduCourseStudent> ecs = new ArrayList<EduCourseStudent>();
			if(students != null && students.size() > 0){
				EduCourseStudent eCourseStudent = new EduCourseStudent();
				eCourseStudent.setUserId(shId);
				eCourseStudent.setStudentId(students.get(0).getStudentId());
				eCourseStudent.setIsPayed(1);
				ecs = eduCourseStudentService.select(eCourseStudent);
			}
			List<EduCourseStudentView> ecsvs = new ArrayList<EduCourseStudentView>();
			List<EduCourse> cs = shCourses.get(shId);
			Map<String, EduCourse> cMap = new HashMap<String, EduCourse>();
			for(EduCourse ec:cs){
				cMap.put(ec.getCourseId(), ec);
			}
			for(EduCourseStudent es : ecs){
				EduCourseStudentView ecsv = new EduCourseStudentView();
				ecsv.setEduCourse(cMap.get(es.getCourseId()));
				ecsv.setEduCourseStudent(es);
				ecsvs.add(ecsv);
			}
			return Result.success(ecsvs);
		}else{
			return Result.failure("参数校验失败","用户微信OPENID或商户ID为空");
		}
	}

	public Result getCourseSt(String shId,String courseSid) {
		EduCourseStudent eCourseStudent = new EduCourseStudent();
		eCourseStudent.setCourseSid(courseSid);
		eCourseStudent = eduCourseStudentService.selectOne(eCourseStudent);
		if(eCourseStudent != null){
			List<EduCourse> cs = shCourses.get(shId);
			Map<String, EduCourse> cMap = new HashMap<String, EduCourse>();
			for(EduCourse ec:cs){
				cMap.put(ec.getCourseId(), ec);
			}
			EduCourseStudentView ecsv = new EduCourseStudentView();
			ecsv.setEduCourse(cMap.get(eCourseStudent.getCourseId()));
			ecsv.setEduCourseStudent(eCourseStudent);
			return Result.success(ecsv);
		}
		return Result.failure("未查到对应信息");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Result prePay(String courseSid, @PathParam("payId") String payId) {
		String sql = "update edu_course_student e set e.is_payed='2',e.pay_id=? where e.course_sid=? and e.is_payed='0';";
		int rs = eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{payId,courseSid});
		if(rs > 0 ){
			return Result.success();
		}else{
			EduCourseStudent eCourseStudent = new EduCourseStudent();
			eCourseStudent.setCourseSid(courseSid);
			eCourseStudent = eduCourseStudentService.selectOne(eCourseStudent);
			if(eCourseStudent != null){
				if(eCourseStudent.getIsPayed().equals(2)){					
					return Result.success();
				} else{					
					return Result.failure("您的课程课程已经失效或已经付款，请刷新您的课程");
				}
			}else{				
				return Result.failure("您未添加该课程");
			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void noPayhandler(Integer warnNum) {
		//检测未缴费的单，并判断可报人数是否为预警库数，是则置为已失效，已报名人数  -1
		EduCourseStudent ecs = new EduCourseStudent();
		ecs.setIsPayed(0);
		List<EduCourseStudent> ecses = eduCourseStudentService.select(ecs);
		for(EduCourseStudent ec:ecses){
			String shId = ec.getUserId();
			if(shCourses.get(shId) == null) this.sysnShCourses(shId);
			for(EduCourse eCourse:shCourses.get(shId)){
				if(eCourse.getCourseId().equals(ec.getCourseId())){
					if(eCourse.getMaxStudents() - eCourse.getPayStudents() < eCourse.getMaxStudents() * warnNum/10){
						String sql = "update edu_course_student ecs set ecs.IS_PAYED='3' where ecs.COURSE_SID=? and ecs.IS_PAYED='0' and ecs.EDIT_DATE<?";
						Date date = new Date(new Date().getTime() - 15*60*1000l);
						int rs = eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{ec.getCourseSid(),date});
						if(rs > 0){
							sql = "update edu_course ec set ec.PAY_STUDENTS=ec.PAY_STUDENTS - 1 where ec.COURSE_ID=? ";
							rs = eduCourseService.getJdbcTemplate().update(sql, new Object[]{ec.getCourseId()});
							this.updateCoursePaynum(shId, eCourse.getCourseId(), -1);
						}
					}
					break;
				}
			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void noPayHanderforDay(Integer offDay) {
		String sql = "select * from edu_course_student ecs where ecs.IS_PAYED='0' and ecs.EDIT_DATE<?";
		Date date = new Date(new Date().getTime() - offDay*12*60*60*1000l);
		List<Map<String, Object>> ecses = eduCourseStudentService.getJdbcTemplate().queryForList(sql, new Object[]{date});
		for(Map<String, Object> ecs:ecses){
			sql = "update edu_course_student ecs set ecs.IS_PAYED='3' where ecs.COURSE_SID=? and ecs.IS_PAYED='0' and ecs.EDIT_DATE<?";
			int rs = eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{ecs.get("COURSE_SID"),date});
			if(rs > 0){
				sql = "update edu_course ec set ec.PAY_STUDENTS=ec.PAY_STUDENTS - 1 where ec.COURSE_ID=? ";
				rs = eduCourseService.getJdbcTemplate().update(sql, new Object[]{ecs.get("COURSE_ID")});
				this.updateCoursePaynum((String)ecs.get("USER_ID"), (String)ecs.get("COURSE_ID"), -1);
			}
		}
	}

}
