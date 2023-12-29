package com.atish.controller;


import com.atish.payload.CommentDto;
import com.atish.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestParam("postId") long postId, @RequestBody CommentDto commentDto) {
        CommentDto comment = commentService.createComment(postId, commentDto);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
       return new ResponseEntity<>("post is deleted",HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentDto>>getCommentsByPostId(@PathVariable long postId){
        List<CommentDto> commentsByPostId = commentService.getCommentsByPostId(postId);
         return new ResponseEntity<>(commentsByPostId,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<List<CommentDto>>getAllComments( ){
        List<CommentDto> allComments = commentService.getAllComments();
        return new ResponseEntity<>(allComments,HttpStatus.OK);
    }



}
