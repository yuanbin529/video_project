package com.qf.dao;

import com.qf.pojo.Speaker;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;
@Repository
public interface SpeakerDao {
    public List<Speaker> findAllSpeaker();
    public Map<String,Object> findSpeaker(Integer page, Integer limit);
    public int addSpeaker(Speaker speaker);
    public int updateSpeaker(Speaker speaker);
    public Speaker findById(Integer id);
    public int deleteById(Integer id);
}
