package com.qf.service;

import com.qf.models.CourseVideoModel;
import com.qf.pojo.Course;


import java.util.List;
import java.util.Map;

public interface CourseService {
    public List<Course> findAllCourse();
    public Map<String, Object> findCourse(Integer page, Integer limit);
    public int addCourse(Course course);
    public CourseVideoModel findCourseAnd(Integer id);
    public int deleteById(Integer id);
    public int updateCourse(Course course);
    public Course findById(Integer id);
}
