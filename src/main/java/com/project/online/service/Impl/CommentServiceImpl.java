package com.project.online.service.Impl;

import com.project.online.DAO.CommentDAO;
import com.project.online.model.Comment;
import com.project.online.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl  implements CommentService {
    @Autowired
    private CommentDAO commentDAO;

    public Comment getComment(long commentId){
        return commentDAO.getComment(commentId);
    }
    public List <Comment> getCommentByEpisodeId(long episodeId){
        return commentDAO.getCommentByEpisodeId(episodeId);}
    public List <Comment> getCommentByUserId(long userId){
        return commentDAO.getCommentByUserId(userId);
    }
    public void addComment(Comment comment){
       commentDAO.addComment(comment);
    }
    public void deleteComment(Comment comment){
        commentDAO.deleteComment(comment);
    }
    public void editComment(Comment comment){
        commentDAO.editComment(comment);
    }
    public List<Comment>getAllComments(){
        return commentDAO.getAllComments();
    }

}
