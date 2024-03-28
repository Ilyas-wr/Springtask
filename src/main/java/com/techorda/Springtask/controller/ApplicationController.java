package com.techorda.Springtask.controller;

import com.techorda.Springtask.model.ApplicationRequest;
import com.techorda.Springtask.repost.ApplicationRequestRepost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationRequestRepost applicationRequestRepost;

    @GetMapping(value = "/home")
    public String getHomePage(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepost.findAll();
        model.addAttribute("applicationReq",applicationRequestList);
        return "home";
    }

    @GetMapping(value = "/newpost")
    public String getNewpost(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepost.findAll();
        model.addAttribute("asp",applicationRequestList);
        return "Newpage";
    }
    @GetMapping(value = "/OldPost")
    public String getOldpost(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepost.findAll();
        model.addAttribute("old",applicationRequestList);
        return "oldpage";
    }

    @GetMapping(value = "/AddReq")
    public String getAddPage(Model model){

        return "add";
    }

    @PostMapping(value = "AddReq")
    public String AddRequest(@RequestParam(value = "fullname") String name,
                             @RequestParam(value = "courser") String coursera,
                             @RequestParam(value = "number") String phone,
                             @RequestParam(value = "comm") String comment){
        ApplicationRequest applicationRequest = new ApplicationRequest();
        applicationRequest.setUserName(name);
        applicationRequest.setCourseName(coursera);
        applicationRequest.setPhone(phone);
        applicationRequest.setCommentary(comment);
        applicationRequestRepost.save(applicationRequest);
        return "redirect:/home";
    }

    @GetMapping(value = "/details/{id}")
    public String getdetailsPage(@PathVariable(value = "id") Long id,Model model){
        ApplicationRequest applicationRequest = applicationRequestRepost.findById(id).orElseThrow();
        model.addAttribute("detailsApp",applicationRequest);
        return "detailspage";
    }


    @PostMapping(value = "/removeReq/{id}")
    public String RemovePage(@PathVariable(value = "id") Long id){
        applicationRequestRepost.deleteById(id);
        return "redirect:/home";
    }

    @PostMapping(value = "/change/{id}")
    public String ChangePage(@PathVariable(value = "id") Long id){

        ApplicationRequest applicationRequest = applicationRequestRepost.findById(id).orElseThrow();
        applicationRequest.setHandled(true);
        applicationRequestRepost.save(applicationRequest);
        return "redirect:/home";
    }
}
