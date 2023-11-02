package com.bae.admintemp.data.entity;

import com.bae.admintemp.data.dto.MemberDto;
import com.bae.admintemp.data.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    String userId;
    String userPw;
    String userName;
    String mobile;
    String email;
    Date expirationAt;
    Date secessionAt;
    String secessionReason;
    String roles;
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    List<Board> list = new ArrayList<>();

    public MemberDto toDto(){
        return MemberDto.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .mobile(mobile)
                .email(email)
                .expirationAt(expirationAt)
                .secessionAt(secessionAt)
                .secessionReason(secessionReason)
                .roles(roles)
                .build();
    }
}