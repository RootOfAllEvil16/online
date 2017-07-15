package com.project.online.controller;

import com.project.online.model.*;
import com.project.online.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ShowService showService;


    @RequestMapping
    public String adminPage() {
        return "admin";
    }



    @RequestMapping("/user")
    public String userManage(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute(userList);

        return "userManagement";
    }


    @RequestMapping("/commentsManagement")
    public String commentManage(Model model) {
        List<Comment> commentList = commentService.getAllComments();
        model.addAttribute(commentList);

        return "commentManagement";
    }

    @RequestMapping("/seriesListManagement")
    public String seriesListManagement(Model model) {
        List<Show> shows = showService.getAllShows();
        model.addAttribute("shows", shows);


        return "seriesListManagement";
    }




}
