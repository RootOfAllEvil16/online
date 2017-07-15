package com.project.online.service.Impl;

import com.project.online.DAO.ShowDAO;
import com.project.online.model.Show;
import com.project.online.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    private ShowDAO showDAO;

    public List<Show> getAllShows() {
        return showDAO.getAllShows();
    }

    public Show getShowByName(String showName) {
        return showDAO.getShowByName(showName);
    }

    public void editShow(Show show) {
        showDAO.editShow(show);
    }

    public void deleteShow(Show show) {
        showDAO.deleteShow(show);
    }

    public void addShow(Show show) {
        showDAO.addShow(show);
    }

    public Show getShowsByGenre(String genre) {
        return showDAO.getShowsByGenre(genre);
    }
    public Show getShowById(long showId){
        return showDAO.getShowById(showId);
    }
}
