package com.project.online.DAO;

import com.project.online.model.Genre;
import com.project.online.model.Show;

import java.util.List;

public interface ShowDAO {

    List<Show> getAllShows();

    Show getShowByName(String showName);

    void editShow(Show show);

    void deleteShow(Show show);

    void addShow(Show show);

    Show getShowsByGenre(String genre);

    Show getShowById(long showId);

}
