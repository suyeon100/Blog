package com.blog.domain.member.entity;

import com.blog.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.jspecify.annotations.NonNull;


@Entity
public class Member extends BaseEntity {


    private String email;

    private String password;

    private String nickname;
}
