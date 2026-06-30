package com.blog.domain.member.entity;

import com.blog.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.jspecify.annotations.NonNull;


@Entity
@Getter
public class Member extends BaseEntity {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    protected Member() {
    }

    public Member(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

}
