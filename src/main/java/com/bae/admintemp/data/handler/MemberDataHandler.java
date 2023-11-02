package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.dto.MemberDto;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Member;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MemberDataHandler {

    Member saveMemberEntity(String userId, String userPw, String userName, String mobile, String email, Date expirationAt,
                            Date secessionAt, String secessionReason, String roles, List<Board> list);

    Member getMemberEntity(String userId);


    Optional<Member> findOne(String userId);

}