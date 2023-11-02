package com.bae.admintemp.data.dto;

import com.bae.admintemp.data.entity.Customer;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    @Email
    private String email;
    private String provider;
    private String grade;
    private String zip;
    private String addr;
    private String addr2;
    private String smsYn;
    private String emailYn;
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

    public Customer toEntity(){
        return Customer.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .mobile(mobile)
                .email(email)
                .provider(provider)
                .grade(grade)
                .zip(zip)
                .addr(addr)
                .addr2(addr2)
                .smsYn(smsYn)
                .emailYn(emailYn)
                .createAt(createAt)
                .updateAt(updateAt)
                .expirationAt(expirationAt)
                .secessionAt(secessionAt)
                .secessionReason(secessionReason)
                .build();
    }
}
