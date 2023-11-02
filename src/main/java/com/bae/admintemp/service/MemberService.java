package com.bae.admintemp.service;

import com.bae.admintemp.data.dto.MemberDto;
import com.bae.admintemp.data.entity.Board;

import java.util.Date;
import java.util.List;

public interface MemberService {
    MemberDto saveMember(String userId, String userPw, String userName, String mobile, String email,
                         Date expirationAt, Date secessionAt, String secessionReason, String roles, List<Board> list);

    MemberDto getMember(String userId);
}