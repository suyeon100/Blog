package com.blog.domain.member.entity;

import groovy.xml.Entity;

import java.time.LocalDateTime;


public class Member {

    private Long id;

    private  String email;

    private String password;

    private String nickname;


    private LocalDateTime createDate;


    private LocalDateTime modifyDate;

}
