package com.project.online.service;


import com.project.online.model.Show;

import java.util.List;

public interface ShowService {
    List<Show> getAllShows();

    Show getShowByName(String showName);

    void editShow(Show show);

    void deleteShow(Show show);

    void addShow(Show show);

    Show getShowsByGenre(String genre);

    Show getShowById(long showId);
}
