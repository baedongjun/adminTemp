package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.entity.Member;

import java.util.Date;

public interface MemberDataHandler {

    Member saveMemberEntity(String userId, String userPw, String userName, String mobile, String email, Date createAt, Date updateAt, Date expirationAt, Date secessionAt, String secessionReason, String roles);

    Member getMemberEntity(String userId);

}