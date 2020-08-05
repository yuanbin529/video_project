package com.qf.controller;

import com.qf.utils.JsonResult;
import com.qf.pojo.Course;
import com.qf.pojo.Speaker;
import com.qf.pojo.Video;
import com.qf.service.CourseService;
import com.qf.service.SpeakerService;
import com.qf.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class VideoController {
    @Autowired
    private VideoService videoservice;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/videoList.do")
    public Map<String,Object> findByPage(HttpSession session,
                                         String searchInfo,
                                         Integer courseId,
                                         Integer speakerId,
                                         Integer page,
                                         Integer limit) {
        Map<String, Object> map = videoservice.findByPage (page, limit, searchInfo, courseId, speakerId);
        return map;
    }

    @RequestMapping("/deleteVideo.do")
    public JsonResult deleteVideo(Integer id) {
        try {
            videoservice.deleteVideo(id);
            return new JsonResult (1,null);
        } catch (Exception e) {
            return new JsonResult (0,e.getMessage ());
        }
    }

    @RequestMapping("/addVideo.do")
    public JsonResult addVideo (Video video) {
        try {
            videoservice.addVideo (video);
            return new JsonResult (1,null);
        } catch (Exception e) {
            return new JsonResult (0,e.getMessage ());
        }
    }

    @RequestMapping("/findSAC.do")
    public Map<String,Object> SpeakerAndCourse() {
        Map<String,Object> responseMap = new HashMap<> ();
        List<Course> course = courseService.findAllCourse ();
        List<Speaker> speaker = speakerService.findAllSpeaker ();
        responseMap.put ("course",course);
        responseMap.put ("speaker",speaker);
        return responseMap;
    }

    @RequestMapping("/queryVideo.do")
    public JsonResult findById(Integer id) {
        Video video = videoservice.findVideo (id);
        return new JsonResult (1, video);
    }
    @RequestMapping("/updateVideo.do")
    public JsonResult updateVideo(Video video) {
        try {
            videoservice.updateVideo (video);
            return new JsonResult (1,null);
        } catch (Exception e) {
            return new JsonResult (0,e.getMessage ());
        }
    }

    @RequestMapping("/deleteSomeVideo.do")
    public JsonResult deleteSomeVideos(String string) {
        String[] array = string.split (",");
        try {
            videoservice.deleteSomeVideos (array);
            return new JsonResult (1,null);
        } catch (Exception e) {
            return new JsonResult (0,e.getMessage());
        }
    }
}
