package com.qf.dao;

import com.qf.models.CourseVideoModel;
import com.qf.pojo.Course;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;
@Repository
public interface CourseDao {
    public List<Course> findAllCourse();
    public Map<String,Object> findCourse(Integer page, Integer limit);
    public int addCourse(Course course);
    public CourseVideoModel findCourseAnd(Integer id);
    public int deleteById(Integer id);
    public Course findById(Integer id);
    public int updateCourse(Course course);

}
