package com.blog.domain.member.dto;

import com.blog.domain.member.entity.Member;

public record MemberInfoRes(
        Long id,
        String nickname

) {
    public static MemberInfoRes from(Member member) {
        return new MemberInfoRes(
                member.getId(),
                member.getNickname()
        );
    }

}
