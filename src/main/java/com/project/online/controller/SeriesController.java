package com.project.online.controller;


import com.project.online.model.*;
import com.project.online.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@Controller

@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private ShowService showService;
    @Autowired
    private SeasonService seasonService;
    @Autowired
    private EpisodeService episodeService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @RequestMapping("/seriesList/all")
    public String getAllSeries(Model model) {
        List<Show> shows = showService.getAllShows();
        model.addAttribute("shows", shows);

        return "seriesList";
    }

    @RequestMapping("/seriesList")
    public String getSeriesByName(@RequestParam("searchCondition") String searchCondition, Model model) {
        List<Show> shows = showService.getAllShows();
        model.addAttribute("shows", shows);
        model.addAttribute("searchCondition", searchCondition);

        return "seriesList";
    }


    @RequestMapping("/contentList/all")
    public String getAllSeasons(Model model) {
        List<Show> shows = showService.getAllShows();
        model.addAttribute("shows", shows);
        List<Season> seasons = seasonService.getAllSeasons();
        model.addAttribute("seasons", seasons);
        List<Episode> episodes = episodeService.getAllEpisodes();
        model.addAttribute("episodes", episodes);
        return "contentList";
    }


    @RequestMapping("/episodeView/{episodeId}")
    public String viewEpisode(@PathVariable long episodeId, Model model) throws IOException {

        Episode episode = episodeService.getEpisodeById(episodeId);
        List<Comment> episodeComments = commentService.getCommentByEpisodeId(episodeId);


        model.addAttribute(episode);
        model.addAttribute(episodeComments);


        return "episodeView";
    }


}