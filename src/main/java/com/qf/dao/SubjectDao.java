package com.qf.dao;

import com.qf.models.SubjectModel;
import com.qf.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectDao {
    public List<Subject> findAllSubject();
    public SubjectModel findSubjectAnd(Integer subjectId);

    Subject findById(String subjectId);

    List<Subject> selectAll();
}
