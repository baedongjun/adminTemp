package com.bae.admintemp.data.entity;

import com.bae.admintemp.data.dto.CustomerDto;
import com.bae.admintemp.data.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "customer")
public class Customer extends BaseEntity {
    @Id
    String userId;
    String userPw;
    String userName;
    String mobile;
    String email;
    String provider;
    String grade;
    String zip;
    String addr;
    String addr2;
    String smsYn;
    String emailYn;
    Date expirationAt;
    Date secessionAt;
    String secessionReason;

    public CustomerDto toDto(){
        return CustomerDto.builder()
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
                .expirationAt(expirationAt)
                .secessionAt(secessionAt)
                .secessionReason(secessionReason)
                .build();
    }
}