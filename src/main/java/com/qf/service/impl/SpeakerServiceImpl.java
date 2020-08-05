package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.dao.SpeakerDao;
import com.qf.pojo.Speaker;
import com.qf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerDao speakerDao;
    @Override
    public List<Speaker> findAllSpeaker() {
        return speakerDao.findAllSpeaker ();
    }

    @Override
    public int addSpeaker(Speaker speaker) {
        return speakerDao.addSpeaker(speaker);
    }

    @Override
    public int updateSpeaker(Speaker speaker) {
        return speakerDao.updateSpeaker (speaker);
    }

    @Override
    public Speaker findById(Integer id) {
        return speakerDao.findById (id);
    }

    @Override
    public int deleteSpeaker(Integer id) {
        return speakerDao.deleteById(id);
    }

    @Override
    public Map<String, Object> findSpeaker(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Speaker> list = speakerDao.findAllSpeaker();

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

}
