package com.blog.domain.member.service;

import com.blog.domain.member.dto.JoinReq;
import com.blog.domain.member.dto.MemberInfoRes;
import com.blog.domain.member.dto.LoginReq;
import com.blog.domain.member.entity.Member;
import com.blog.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public MemberInfoRes join(JoinReq req) {
        if (memberRepository.existsByEmail(req.email())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(req.password());

        Member member = new Member(
                req.email(),
                encodedPassword,
                req.nickname()
        );
        Member savedMember = memberRepository.save(member);

        return MemberInfoRes.from(savedMember);
    }


    public MemberInfoRes login(LoginReq req){
        Member member = memberRepository.findByEmail(req.email())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다."));

        if (!passwordEncoder.matches(req.password(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return MemberInfoRes.from(member);
    }



}
