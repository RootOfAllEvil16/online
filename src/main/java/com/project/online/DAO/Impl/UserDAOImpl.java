package com.project.online.DAO.Impl;

import com.project.online.DAO.UserDAO;
import com.project.online.model.Authorities;
import com.project.online.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setUserId(user.getUserId());
        newUser.setEmail(user.getEmail());
        newUser.setEnabled();

        Authorities newAuthority = new Authorities();
        newAuthority.setUserName(user.getUserName());
        newAuthority.setAuthority("ROLE_USER");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        session.flush();
    }

    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        session.flush();
    }

    public User getUserById(long userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, userId);
        session.flush();

        return user;

    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        List<User> userList = query.list();
        session.flush();
        return userList;
    }

    public User getUserByName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where userName = ?");
        query.setString(0, userName);

        return (User) query.uniqueResult();
    }
}


