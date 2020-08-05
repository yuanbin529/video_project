package com.qf.controller;

import com.qf.models.CourseVideoModel;
import com.qf.models.SubjectModel;
import com.qf.models.VideoModel;
import com.qf.pojo.Subject;
import com.qf.service.CourseService;
import com.qf.service.SubjectService;
import com.qf.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @RequestMapping("/course/list.do")
    public String courseAndList(String subjectId, Model model){
        SubjectModel sub = subjectService.findSubjectAnd(Integer.parseInt(subjectId));
        model.addAttribute("subject",sub);
        return "course";
    }

    @RequestMapping("/showVideo.do")
    public ModelAndView showVideo(Integer videoId, String subjectName){
        Map<String,Object> map = new HashMap<> ();
        VideoModel videoModel = videoService.videoAndSpeaker(videoId);
        CourseVideoModel course = courseService.findCourseAnd(videoModel.getCourseId());

        map.put("video",videoModel);
        map.put("subjectName",subjectName);
        map.put("course",course);

        return new ModelAndView("section",map);
    }

    @RequestMapping("/subject/selectAll")
    public ModelAndView selectAll(HttpServletRequest request) {
        ServletContext servletContext = request.getSession().getServletContext();
        List<Subject> subjectList = subjectService.selectAll();
        servletContext.setAttribute("subjectList",subjectList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/jsp/before/index.jsp");
        return modelAndView;
    }

}
