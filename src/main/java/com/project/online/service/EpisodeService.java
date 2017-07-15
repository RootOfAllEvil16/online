package com.project.online.service;


import com.project.online.model.Episode;

import java.util.List;

public interface EpisodeService {
    List<Episode> getAllEpisodes();

    void editEpisode(Episode episode);

    void deleteEpisode(Episode episode);

    void addEpisode(Episode episode);

    Episode getEpisodeById(long episodeId);

    Episode getEpisodeByNum(int episodeNum);


}
