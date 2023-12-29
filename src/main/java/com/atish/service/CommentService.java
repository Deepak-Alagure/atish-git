package com.atish.service;

import com.atish.payload.CommentDto;

import java.util.List;

public interface CommentService {


    CommentDto createComment(long postId, CommentDto commentDto);

    void deleteComment(long id);


    List<CommentDto> getCommentsByPostId(long postId);

    List<CommentDto> getAllComments();
}
