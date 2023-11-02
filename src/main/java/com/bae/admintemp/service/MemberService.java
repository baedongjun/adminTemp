package com.bae.admintemp.service;

import com.bae.admintemp.data.dto.MemberDto;

import java.util.Date;
import java.util.Optional;

public interface MemberService {
    MemberDto saveMember(String userId, String userPw, String userName, String mobile, String email,
                         Date createAt, Date updateAt, Date expirationAt, Date secessionAt,
                         String secessionReason, String roles);

    MemberDto getMember(String userId);

    Optional<MemberDto> findOne(String userId);
}