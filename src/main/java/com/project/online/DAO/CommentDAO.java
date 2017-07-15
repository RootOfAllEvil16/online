package com.project.online.DAO;


import com.project.online.model.Comment;

import java.util.List;


public interface CommentDAO {


    Comment getComment(long commentId);

    List<Comment> getCommentByEpisodeId(long episodeId);

    List<Comment> getCommentByUserId(long userId);

    void deleteComment(Comment comment);

    void editComment(Comment comment);

    List<Comment> getAllComments();

    void addComment(Comment comment);

}