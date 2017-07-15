package com.project.online.service.Impl;

import com.project.online.DAO.SeasonDAO;
import com.project.online.model.Season;
import com.project.online.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService {
    @Autowired
    private SeasonDAO seasonDAO;

    public List<Season> getAllSeasons() {
        return seasonDAO.getAllSeasons();
    }


    public Season getSeasons(int seasonNum) {
        return seasonDAO.getSeasons(seasonNum);
    }

    public void editSeason(Season season) {
        seasonDAO.editSeason(season);
    }

    public void deleteSeason(Season season) {
        seasonDAO.deleteSeason(season);
    }

    public void addSeason(Season season) {
        seasonDAO.addSeason(season);
    }

    public Season getSeasonById(long seasonId) {
        return seasonDAO.getSeasonById(seasonId);
    }

}
