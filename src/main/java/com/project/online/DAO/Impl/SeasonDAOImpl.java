package com.project.online.DAO.Impl;

import com.project.online.DAO.SeasonDAO;
import com.project.online.model.Season;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SeasonDAOImpl implements SeasonDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Season> getAllSeasons() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Season");
        List<Season> seasonList = query.list();
        session.flush();
        return seasonList;
    }


    public Season getSeasons(int seasonNum) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Season  where seasonNum=?");
        query.setInteger(0, seasonNum);
        session.flush();

        return (Season) query.uniqueResult();
    }

    public void editSeason(Season season) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(season);
        session.flush();
    }

    public void deleteSeason(Season season) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(season);
        session.flush();
    }

    public void addSeason(Season season) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(season);
        session.flush();
    }

    public Season getSeasonById(long seasonId) {
        Session session = sessionFactory.getCurrentSession();
        Season season = (Season) session.get(Season.class,seasonId);
        session.flush();

        return season;
    }


}
