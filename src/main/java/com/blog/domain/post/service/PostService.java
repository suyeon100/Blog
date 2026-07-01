package com.blog.domain.post.service;

import com.blog.domain.member.entity.Member;
import com.blog.domain.member.repository.MemberRepository;
import com.blog.domain.post.dto.PostCreateReq;
import com.blog.domain.post.dto.PostInfoRes;
import com.blog.domain.post.dto.PostListRes;
import com.blog.domain.post.dto.PostUpdateReq;
import com.blog.domain.post.entity.Post;
import com.blog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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



    public List<PostListRes> getPosts(){
        return postRepository.findAll()
                .stream()
                .map(PostListRes::from)
                .toList();

    }


    public PostInfoRes updatePost(Long postId,PostUpdateReq req){

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글 입니다."));



        post.update(req.title(), req.content());

        Post savedPost = postRepository.save(post);

        return PostInfoRes.from(savedPost);


    }


    public void deletePost(Long postId){

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));


        postRepository.delete(post);

    }







}
