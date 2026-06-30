package com.blog.domain.member.dto;

public record JoinReq(
        String email,
        String password,
        String nickname
){
}
