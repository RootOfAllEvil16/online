package com.project.online.service;


import com.project.online.model.Comment;

import java.util.List;

public interface CommentService {
    Comment getComment(long commentId);

   List<Comment> getCommentByEpisodeId(long episodeId);

   List <Comment> getCommentByUserId(long userId);

    void addComment(Comment comment);

    void deleteComment(Comment comment);

    void editComment(Comment comment);

    List<Comment>getAllComments();


}
