package com.atish.service.impl;


import com.atish.entity.Post;
import com.atish.exception.ResourceNotFoundException;
import com.atish.payload.PostDto;
import com.atish.repository.PostRepository;
import com.atish.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public void createPost(PostDto postDto) {

        Post post = new Post();
         post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
         post.setContent(postDto.getContent());


        postRepo.save(post);
    }

    @Override
    public void deletePost(long id) {

        postRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found:"+id)
        );

        postRepo.deleteById(id);
    }

    @Override
    public List<PostDto> gettAllReg(int pageNo, int pageSize, String sortBy, String sortDir) {
Sort sort=(sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():
        Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> all = postRepo.findAll(pageable);
        List<Post> content = all.getContent();
        List<PostDto> collect = content.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public PostDto updateReg(long postId, PostDto postDto) {
        Post post = postRepo.findById(postId).orElseThrow
                (() -> new ResourceNotFoundException("post not found with id" + postId));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        postRepo.save(post);
        PostDto dto = mapToDto(post);
        return dto;
    }

    static PostDto mapToDto(Post post){

        PostDto dto =new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());

        return dto;

}

}
