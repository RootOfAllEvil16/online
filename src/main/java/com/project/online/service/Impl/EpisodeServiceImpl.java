package com.project.online.service.Impl;

import com.project.online.DAO.EpisodeDAO;
import com.project.online.model.Episode;
import com.project.online.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {
    @Autowired
    private EpisodeDAO episodeDAO;

    public List<Episode> getAllEpisodes() {
        return episodeDAO.getAllEpisodes();
    }


    public void editEpisode(Episode episode) {
        episodeDAO.editEpisode(episode);
    }

    public void deleteEpisode(Episode episode) {
        episodeDAO.deleteEpisode(episode);
    }

    public void addEpisode(Episode episode) {
        episodeDAO.addEpisode(episode);
    }

    public Episode getEpisodeById(long episodeId) {
        return episodeDAO.getEpisodeById(episodeId);
    }

    public Episode getEpisodeByNum(int episodeNum) {
        return episodeDAO.getEpisodeByNum(episodeNum);
    }


}
