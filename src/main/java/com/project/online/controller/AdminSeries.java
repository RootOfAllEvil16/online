package com.project.online.controller;

import com.project.online.model.Episode;
import com.project.online.model.Genre;
import com.project.online.model.Season;
import com.project.online.model.Show;
import com.project.online.service.EpisodeService;
import com.project.online.service.SeasonService;
import com.project.online.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("/admin")
public class AdminSeries {
    @Autowired
    private ShowService showService;
    @Autowired
    private SeasonService seasonService;
    @Autowired
    private EpisodeService episodeService;
    private Path path;


    @RequestMapping("/series/addShow")
    public String addShow(Model model) {
        Show show = new Show();
        show.setShowName("");
        show.setGenre(Genre.SCIFI);


        model.addAttribute("show", show);

        return "addShow";
    }

    @RequestMapping(value = "/series/addShow", method = RequestMethod.POST)
    public String addShowPost(@Valid @ModelAttribute("show") Show show, BindingResult result,
                              HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addShow";
        }
        showService.addShow(show);


        MultipartFile showImage = show.getShowImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + show.getShowId() + ".png");

        System.out.println(path);

        if (showImage != null && !showImage.isEmpty()) {
            try {
                showImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Show image saving failed", e);
            }
        }

        return "redirect:/admin/series/addSeason";
    }


    @RequestMapping("/series/deleteShow/{showId}")
    public String deleteShow(@PathVariable long showId, Model model, HttpServletRequest request) {

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + showId + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Show show = showService.getShowById(showId);
        showService.deleteShow(show);
        return "redirect:/admin/seriesListManagement";

    }


    @RequestMapping("/series/addSeason")
    public String addSeason(Model model) {
        model.addAttribute("season", new Season());
        model.addAttribute("show", new Show());

        model.addAttribute("seasonList", seasonService.getAllSeasons());
        model.addAttribute("showList", showService.getAllShows());

        return "addSeason";
    }

    @RequestMapping(value = "/series/addSeason", method = RequestMethod.POST)
    public String addSeasonPost(@Valid @ModelAttribute("season") Season season, BindingResult result, Model model) {
        if (result.hasErrors()) {

            model.addAttribute("showList", showService.getAllShows());
            return "addSeason";
        }


        seasonService.addSeason(season);


        return "redirect:/admin/series/addEpisode";
    }

    @RequestMapping("/series/addEpisode")
    public String addEpisode(Model model) {
        model.addAttribute("episode", new Episode());
        model.addAttribute("season", new Season());

        model.addAttribute("seasonList", seasonService.getAllSeasons());
        model.addAttribute("episodeList", episodeService.getAllEpisodes());


        return "addEpisode";
    }

    @RequestMapping(value = "/series/addEpisode", method = RequestMethod.POST)
    public String addEpisodePost(@Valid @ModelAttribute("episode") Episode episode, BindingResult result,
                                 HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addEpisode";
        }
        episodeService.addEpisode(episode);

        MultipartFile episodeImage = episode.getEpisodeImage();
        MultipartFile videoFile = episode.getVideoFile();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");


        System.out.println(path);

        if (episodeImage != null && !episodeImage.isEmpty()) {
            try {
                episodeImage.transferTo(new File(rootDirectory + "WEB-INF/resources/images/" + episode.getEpisodeId() + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Episode image saving failed", e);
            }
        }
        if (videoFile != null && !videoFile.isEmpty()) {
            try {
                videoFile.transferTo(new File(rootDirectory + "WEB-INF/resources/video/" + episode.getEpisodeId() + ".mp4"));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Episode video saving failed", e);
            }
        }


        return "redirect:/series/seriesList/all";
    }


//You can also use another method to insert multipart files path to database

    /*@RequestMapping(value = "/series/addEpisode", method = RequestMethod.POST)
    public String save(@ModelAttribute ("episode") Episode episode,
                       MultipartFile newVideo,
                       MultipartFile newImage,
                       HttpServletRequest request, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("seasonList", seasonService.getAllSeasons());
            return "addEpisode";
        }
        String videoFormat =
                newVideo.getOriginalFilename()
                        .substring(newVideo.getOriginalFilename().lastIndexOf("."));

        String imageFormat =
                newImage.getOriginalFilename()
                        .substring(newImage.getOriginalFilename().lastIndexOf("."));

        //int uuid = UUID.randomUUID()..replace("-","");

        //episode.setEpisodeId(episodeId);


        String upLoadDic = request.getServletContext().getRealPath("WEB-INF/resources/");
        String videoPath = upLoadDic+"video/" + episode.getEpisodeId() + videoFormat;
        String imagePath = upLoadDic+"images/" +  episode.getEpisodeId() + imageFormat;
        System.out.println(videoPath);
        System.out.println(imagePath);
        File videoFile = new File(videoPath);
        File photoFile = new File(imagePath);
        newVideo.transferTo(videoFile);
        newImage.transferTo(photoFile);
        episode.setVideoPath(videoPath);
        episode.setEpisodeImage(imagePath);
        episodeService.addEpisode(episode);
        return "redirect:/series/seriesList/all";


}
}*/

}
