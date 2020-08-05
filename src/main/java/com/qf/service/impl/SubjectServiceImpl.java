package com.qf.service.impl;

import com.qf.dao.SubjectDao;
import com.qf.models.SubjectModel;
import com.qf.pojo.Subject;
import com.qf.service.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> findAllSubject() {
        return subjectDao.findAllSubject();
    }

    @Override
    public SubjectModel findSubjectAnd(Integer subjectId) {
        return subjectDao.findSubjectAnd (subjectId);
    }

    @Override
    public Subject findById(String subjectId) {
        return subjectDao.findById(subjectId);
    }

    @Override
    public List<Subject> selectAll() {

        return subjectDao.selectAll();
    }
}
