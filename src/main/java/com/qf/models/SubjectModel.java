package com.qf.models;

import lombok.Data;

import java.util.List;
@Data
public class SubjectModel {

    private Integer id;
    private String subjectName;
    private List<CourseModel> courseList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<CourseModel> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseModel> courseList) {
        this.courseList = courseList;
    }
}
