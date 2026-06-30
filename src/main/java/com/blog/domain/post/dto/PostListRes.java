package com.blog.domain.post.dto;

import com.blog.domain.post.entity.Post;

import java.time.LocalDateTime;

public record PostListRes(

        Long id,
        String nickname,
        String title,
        String content,
        LocalDateTime createDate,
        LocalDateTime modifyDate

) {

    public static PostListRes from(Post post) {
        return new PostListRes(
                post.getId(),
                post.getMember().getNickname(),
                post.getTitle(),
                post.getContent(),
                post.getCreateDate(),
                post.getModifyDate()

        );
    }

}
