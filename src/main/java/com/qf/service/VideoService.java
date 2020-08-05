package com.qf.service;

import com.qf.models.VideoModel;
import com.qf.pojo.Video;


import java.util.Map;

public interface VideoService {
  public Map<String,Object> findByPage(Integer page, Integer limit, String searchInfo, Integer courseId, Integer speakerId);
  public VideoModel videoAndSpeaker(Integer id);
  public  int deleteVideo(Integer id);
  public int addVideo(Video video);
  public Video findVideo(Integer id);
  public int updateVideo(Video video);
  public int deleteSomeVideos(String[] arr);
}
