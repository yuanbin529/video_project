package com.qf.service;

import com.qf.pojo.Speaker;


import java.util.List;
import java.util.Map;

public interface SpeakerService {
    public Map<String,Object> findSpeaker(Integer page, Integer limit);
    public List<Speaker> findAllSpeaker();
    public int addSpeaker(Speaker speaker);
    public int updateSpeaker(Speaker speaker);
    public Speaker findById(Integer id);
    public int deleteSpeaker(Integer id);
}
