package com.project.online.DAO.Impl;

import com.project.online.DAO.EpisodeDAO;
import com.project.online.model.Episode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EpisodeDAOImpl implements EpisodeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Episode> getAllEpisodes() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Episode");
        List<Episode> episodeList = query.list();
        session.flush();
        return episodeList;
    }


    public void editEpisode(Episode episode) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(episode);
        session.flush();
    }

    public void deleteEpisode(Episode episode) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(episode);
        session.flush();
    }

    public void addEpisode(Episode episode) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(episode);
        session.flush();
    }

    public Episode getEpisodeById(long episodeId) {
        Session session = sessionFactory.getCurrentSession();
        Episode episode = (Episode) session.get(Episode.class, episodeId);
        session.flush();

        return episode;
    }

    public Episode getEpisodeByNum(int episodeNum) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Episode  where episodeNum=?");
        query.setInteger(0, episodeNum);
        session.flush();

        return (Episode) query.uniqueResult();
    }


}