package com.project.online.controller;


import com.project.online.model.Comment;
import com.project.online.model.Episode;
import com.project.online.model.User;
import com.project.online.service.CommentService;
import com.project.online.service.EpisodeService;
import com.project.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;


@Controller

@RequestMapping("/user")
public class UserController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private EpisodeService episodeService;


    @RequestMapping(value = "/series/episodeView/{episodeId}/addComment")
    public String addComment(Model model, @PathVariable long episodeId) {
        Comment comment = new Comment();
        comment.setEpisode(episodeService.getEpisodeById(episodeId));

        model.addAttribute("comment", comment);

        return "addComment";
    }

    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = "/series/episodeView/{episodeId}/addComment", method = RequestMethod.POST)
    public String addComment(@PathVariable long episodeId,
                             @Valid @ModelAttribute("comment") Comment comment,
                             BindingResult result, Model model, Principal principal) {
        if (result.hasErrors()) {
            return "addComment";
        }
        Episode episode = episodeService.getEpisodeById(episodeId);
        User user = userService.getUserByName(principal.getName());
        Date date = new Date();

        comment.setCommentDate(date);
        comment.setEpisode(episode);
        comment.setUser(user);
        episode.addComment(comment);


        commentService.addComment(comment);

        model.addAttribute("comment", comment);

        return "redirect:/commentsList/all";

    }


}