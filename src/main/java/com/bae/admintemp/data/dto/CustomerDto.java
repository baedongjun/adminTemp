package com.bae.admintemp.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "customer", timeToLive = 60)
public class CustomerDto {
    @NotNull
    @Id
    private String userId;
    private String userPw;
    private String userName;
    private String mobile;
    private String email;
    private String provider;
    private String grade;
    private String zip;
    private String addr;
    private String addr2;
    private String smsYn;
    private String emailYn;
    private Date createAt;
    private Date updateAt;
    private Date expirationAt;
    private Date secessionAt;
    private String secessionReason;
}
