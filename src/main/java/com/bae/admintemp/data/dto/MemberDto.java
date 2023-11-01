package com.bae.admintemp.data.dto;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "member", timeToLive = 60)
public class MemberDto {

    private String userId;
    private String userPw;
    private String userName;
    private String mobile;
    private String email;
    private Date createAt;
    private Date updateAt;
    private Date expirationAt;
    private Date secessionAt;
    private String secessionReason;
    private String roles;

}