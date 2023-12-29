package com.atish.service;

import com.atish.payload.PostDto;

import java.util.List;

public interface PostService {
    public void createPost(PostDto postDto);

    public void deletePost(long id);


    List<PostDto> gettAllReg(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto updateReg(long postId, PostDto postDto);
}
