package com.project.online.DAO.Impl;

import com.project.online.DAO.ShowDAO;
import com.project.online.model.Show;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class ShowDAOImpl implements ShowDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Show> getAllShows() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Show");
        List<Show> showList = query.list();
        session.flush();
        return showList;
    }

    public Show getShowByName(String showName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Show WHERE showName = ?");
        query.setString(0, showName);

        return (Show) query.uniqueResult();
    }

    public void editShow(Show show) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(show);
        session.flush();
    }

    public void deleteShow(Show show) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(show);
        session.flush();
    }

    public void addShow(Show show) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(show);
        session.flush();
    }


    public Show getShowsByGenre(String genre) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Show where genre=?");
        query.setString(0, genre);

        return (Show) query.uniqueResult();
    }

    public Show getShowById(long showId) {
        Session session = sessionFactory.getCurrentSession();
        Show show = (Show) session.get(Show.class, showId);
        session.flush();

        return show;
    }


}