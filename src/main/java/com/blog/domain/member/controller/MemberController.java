package com.blog.domain.member.controller;

import com.blog.domain.member.dto.JoinReq;
import com.blog.domain.member.dto.MemberInfoRes;
import com.blog.domain.member.dto.LoginReq;
import com.blog.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/join")
    public MemberInfoRes join(@RequestBody JoinReq req) {
        return memberService.join(req);
    }

    @PostMapping("/login")
    public MemberInfoRes login(@RequestBody LoginReq req){

        return memberService.login(req);
    }


}
