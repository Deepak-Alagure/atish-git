package com.atish.service.impl;

import com.atish.entity.Comment;
import com.atish.entity.Post;
import com.atish.exception.ResourceNotFoundException;
import com.atish.payload.CommentDto;
import com.atish.repository.CommentRepository;
import com.atish.repository.PostRepository;
import com.atish.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    private CommentRepository commentRepository;


    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post id = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("poste not found by id" + postId)
        );
        Comment comment =new Comment();
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setPost(id);

        Comment save = commentRepository.save(comment);
        CommentDto dto=new CommentDto();
        dto.setId(save.getId());
        dto.setBody(save.getBody());
        dto.setEmail(save.getEmail());
        dto.setName(save.getName());

        return dto;

    }

    @Override
    public void deleteComment(long id) {
        commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comments not found by this id:"+id)
        );
      commentRepository.deleteById(id);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {

        List<Comment>comments=commentRepository.findByPostId(postId);
        List<CommentDto> collect = comments.stream().map(p -> maptoCommentDto(p)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> all = commentRepository.findAll();
        List<CommentDto> collect = all.stream().map(p -> maptoCommentDto(p)).collect(Collectors.toList());
        return collect;
    }

    CommentDto maptoCommentDto(Comment comments){
        CommentDto c = new CommentDto();
        c.setId(comments.getId());
        c.setName(comments.getName());
        c.setBody(comments.getBody());
        c.setEmail(comments.getEmail());
        return c;
    }


}
