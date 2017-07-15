package com.project.online.controller;

import com.project.online.model.Comment;
import com.project.online.service.CommentService;
import com.project.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/admin")
public class AdminComment {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;


    @RequestMapping("/deleteComment/{commentId}")
    public String deleteComment(@PathVariable long commentId) {


        Comment comment = commentService.getComment(commentId);
        commentService.deleteComment(comment);

        return "redirect:/admin/commentsManagement";
    }


}
