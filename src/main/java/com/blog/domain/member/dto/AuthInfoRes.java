package com.blog.domain.member.dto;

import java.time.LocalDate;

public record AuthInfoRes(
        Long id,
        String nickname,
        String accessToken

) {

}
