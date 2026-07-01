package com.blog.domain.post.controller;


import com.blog.domain.post.dto.PostInfoRes;
import com.blog.domain.post.dto.PostListRes;
import com.blog.domain.post.dto.PostUpdateReq;
import com.blog.domain.post.service.PostService;
import com.blog.domain.post.dto.PostCreateReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //전체조회

    @GetMapping
    public ResponseEntity<List<PostListRes>> getPosts() {
        List<PostListRes> response = postService.getPosts();

        return ResponseEntity.ok(response);
    }


    //생성

    @PostMapping
    public ResponseEntity<PostInfoRes> createPost(
            @RequestParam Long memberId,
            @Valid @RequestBody PostCreateReq request
    ) {
        PostInfoRes response  = postService.createPost(memberId,request);

        return ResponseEntity.ok(response);

    }

    //수정
    @PutMapping("/{postId}")
    public ResponseEntity<PostInfoRes> updatePost(
            @PathVariable Long postId,
            @Valid @RequestBody PostUpdateReq request
    ) {
        PostInfoRes response = postService.updatePost(postId, request);

        return ResponseEntity.ok(response);
    }



    //삭제

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(
            @PathVariable Long postId
    ) {
        postService.deletePost( postId);

        return ResponseEntity.noContent().build();
    }

}
