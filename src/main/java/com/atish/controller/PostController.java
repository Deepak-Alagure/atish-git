package com.atish.controller;


import com.atish.payload.PostDto;

import com.atish.service.PostService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    public PostController(PostService postService) {
        this.postService = postService;
    }
    private PostService postService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping


    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


        postService.createPost(postDto);
        return new ResponseEntity<>("Post is created", HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post is deleted", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> gettAllReg(@RequestParam(name="pageNo", defaultValue= "0",required = false)int pageNo,
                                        @RequestParam(name="pageSize",defaultValue = "3",required = false)int pageSize,
                                        @RequestParam(name ="sortBy",defaultValue = "id",required = false)String sortBy,
                                        @RequestParam(name = "sortDir",defaultValue = "asc",required = false)String sortDir){
        List<PostDto>dtos =postService.gettAllReg(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<?>updateReg(@RequestParam("postid") long postId,@RequestBody PostDto postDto){
        PostDto dto = postService.updateReg(postId, postDto);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }



}
