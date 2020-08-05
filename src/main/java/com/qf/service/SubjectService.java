package com.qf.service;

import com.qf.models.SubjectModel;
import com.qf.pojo.Subject;


import java.util.List;

public interface SubjectService {
    public List<Subject> findAllSubject();
    public SubjectModel findSubjectAnd(Integer subjectId);

    Subject findById(String subjectId);

    List<Subject> selectAll();
}
