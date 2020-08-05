package com.qf.controller;

import com.qf.utils.JsonResult;
import com.qf.pojo.Speaker;
import com.qf.service.SpeakerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@ResponseBody
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;
    @RequestMapping("/speakerList.do")
    public Map<String,Object> findAllSpeaker(Integer page, Integer limit){
        Map<String, Object> map = speakerService.findSpeaker(page,limit);
        return map;
    }
    @RequestMapping("/addSpeaker.do")
    public JsonResult addSpeaker(Speaker speaker) {
        try {
            speakerService.addSpeaker (speaker);
            return new JsonResult (1,null);
        } catch (Exception e) {
            return new JsonResult (0,e.getMessage ());
        }
    }

    @RequestMapping("/updateSpeaker.do")
    public JsonResult updateSpeaker(Speaker speaker) {
        try {
            speakerService.updateSpeaker (speaker);
            return  new JsonResult (1,null);
        } catch (Exception e) {
            return new JsonResult (0,e.getMessage ());
        }
    }

    @RequestMapping("/querySpeaker.do")
    public JsonResult findById(Integer id) {
        Speaker speaker = speakerService.findById (id);
        return new JsonResult (1,speaker);
    }

    @RequestMapping("/deleteSpeaker.do")
    public JsonResult deleteById(Integer id) {
        try {
            speakerService.deleteSpeaker (id);
            return new JsonResult (1,null);
        } catch (Exception e) {
            return new JsonResult (0,e.getMessage ());
        }
    }
}
