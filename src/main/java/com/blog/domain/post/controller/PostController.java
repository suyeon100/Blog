package com.blog.domain.post.controller;


import com.blog.domain.post.dto.PostInfoRes;
import com.blog.domain.post.service.PostService;
import com.blog.domain.post.dto.PostCreateReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //전체조회



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






    //삭제


}
