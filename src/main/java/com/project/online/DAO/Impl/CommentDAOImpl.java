package com.project.online.DAO.Impl;


import com.project.online.DAO.CommentDAO;
import com.project.online.model.Comment;
import com.project.online.model.Episode;
import com.project.online.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Comment getComment(long commentId) {
        Session session = sessionFactory.getCurrentSession();
        Comment comment = (Comment) session.get(Comment.class, commentId);
        session.flush();
        return comment;
    }

    public void deleteComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(comment);
        session.flush();
    }

    public void editComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(comment);
        session.flush();

    }

    public List<Comment> getAllComments() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Comment");
        List<Comment> commentList = query.list();
        session.flush();
        return commentList;
    }

    public List<Comment> getCommentByEpisodeId(long episodeId) {
        Session session = sessionFactory.getCurrentSession();
        Episode episode = (Episode) session.get(Episode.class, episodeId);
        List<Comment> episodeComments = episode.getEpisodeComments();
        session.flush();
        return episodeComments;

    }

    public List<Comment> getCommentByUserId(long userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, userId);
        List<Comment> userComments = user.getUserComments();
        session.flush();
        return userComments;
    }
    public void addComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(comment);
        session.flush();
    }
}

