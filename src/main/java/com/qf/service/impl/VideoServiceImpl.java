package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.dao.VideoDao;
import com.qf.models.VideoModel;
import com.qf.pojo.Video;
import com.qf.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public Map<String, Object> findByPage(Integer page, Integer limit, String searchInfo, Integer courseId, Integer speakerId) {
        PageHelper.startPage(page,limit);
        List<VideoModel> list = videoDao.findAllVideo(searchInfo,courseId,speakerId);

        // 获取总记录数
        long total = ((Page) list).getTotal();
        // 获取总页数
        int pages = ((Page) list).getPages();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    @Override
    public VideoModel videoAndSpeaker(Integer id) {
        return videoDao.videoAndSpeaker (id);
    }


    @Override
    public int deleteVideo(Integer id) {
        return videoDao.deleteById (id);
    }

    @Override
    public int addVideo(Video video) {
        return videoDao.addVideo (video);
    }

    @Override
    public Video findVideo(Integer id) {
        return videoDao.findById (id);
    }

    @Override
    public int updateVideo(Video video) {
        return videoDao.updateVideo (video);
    }

    @Override
    public int deleteSomeVideos(String[] arr) {
        return videoDao.deleteSomeVideos (arr);
    }


}

