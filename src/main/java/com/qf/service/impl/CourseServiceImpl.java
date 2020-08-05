package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.dao.CourseDao;
import com.qf.models.CourseVideoModel;
import com.qf.pojo.Course;
import com.qf.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> findAllCourse() {
        return courseDao.findAllCourse ();
    }

    @Override
    public Map<String, Object> findCourse(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Course> list = courseDao.findAllCourse ();

        // 获取总记录数
        long total = ((Page) list).getTotal();
        // 获取总页数
        int pages = ((Page) list).getPages();

        Map<String, Object> map = new HashMap<> ();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;

    }

    @Override
    public int addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    @Override
    public CourseVideoModel findCourseAnd(Integer id) {
        return courseDao.findCourseAnd (id);
    }

    @Override
    public int deleteById(Integer id) {
        return courseDao.deleteById (id);
    }

    @Override
    public int updateCourse(Course course) {
        return courseDao.updateCourse (course);
    }

    @Override
    public Course findById(Integer id) {
        return courseDao.findById (id);
    }

}
