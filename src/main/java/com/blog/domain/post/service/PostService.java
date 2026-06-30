package com.blog.domain.post.service;

import com.blog.domain.member.entity.Member;
import com.blog.domain.member.repository.MemberRepository;
import com.blog.domain.post.dto.PostCreateReq;
import com.blog.domain.post.dto.PostInfoRes;
import com.blog.domain.post.entity.Post;
import com.blog.domain.post.repository.PostRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public PostInfoRes createPost(Long memberId, PostCreateReq req){

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Post post = new Post(
                member,
                req.title(),
                req.content()
        );


        Post savedPost = postRepository.save(post);

        return PostInfoRes.from(savedPost);
    }



}
