package com.project.online.service;


import com.project.online.model.Season;

import java.util.List;

public interface SeasonService {
    List<Season> getAllSeasons();

    Season getSeasons(int seasonNum);

    void editSeason(Season season);

    void deleteSeason(Season season);

    void addSeason(Season season);

    Season getSeasonById(long seasonId);


}

