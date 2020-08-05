package com.qf.dao;

import com.qf.models.VideoModel;
import com.qf.pojo.Video;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VideoDao {
    public List<VideoModel> findAllVideo(@Param("searchInfo") String searchInfo,
                                         @Param("courseId") Integer courseId,
                                         @Param("speakerId") Integer speakerId);
    public VideoModel videoAndSpeaker(Integer id);
    public Video findById(Integer id);
    public int deleteById(Integer id);
    public int addVideo(Video video);
    public int updateVideo(Video video);
    public int deleteSomeVideos(String[] arr);
}
