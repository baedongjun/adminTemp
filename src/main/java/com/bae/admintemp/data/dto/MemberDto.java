package com.bae.admintemp.data.dto;

import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.data.entity.Product;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "member", timeToLive = 60)
public class MemberDto {
    @NotNull
    @Id
    private String userId;
    private String userPw;
    private String userName;
    private String mobile;
    @Email
    private String email;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createAt;
    @Temporal(value = TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateAt;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date expirationAt;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date secessionAt;
    private String secessionReason;
    private String roles;

    List<Board> list = new ArrayList<>();

    public Member toEntity(){
        return Member.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .mobile(mobile)
                .email(email)
                .createAt(createAt)
                .updateAt(updateAt)
                .expirationAt(expirationAt)
                .secessionAt(secessionAt)
                .secessionReason(secessionReason)
                .roles(roles)
                .list(list)
                .build();
    }
}