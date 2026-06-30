package com.blog.domain.post.dto;

import com.blog.domain.post.entity.Post;

import java.time.LocalDateTime;

public record PostInfoRes(

        Long id,
        String nickname,
        String title,
        String content,
        LocalDateTime createDate,
        LocalDateTime modifyDate



) {
    public static PostInfoRes from(Post post) {
        return new PostInfoRes(
                post.getId(),
                post.getMember().getNickname(),
                post.getTitle(),
                post.getContent(),
                post.getCreateDate(),
                post.getModifyDate()

        );
    }

}
