package com.dt.dtpt.service.demo.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.demo.EduCourse;
import com.dt.dtpt.service.demo.EduCourseService;
import com.dt.dtpt.service.impl.BaseService;
@Service(value = "eduCourseService")
@Transactional(readOnly = true)
public class EduCourseServiceImpl extends BaseService<EduCourse> implements EduCourseService {

}
