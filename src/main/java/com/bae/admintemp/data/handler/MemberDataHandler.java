package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.entity.Member;

public interface MemberDataHandler {

    Member saveMemberEntity(String memberId, String memberName, int memberPrice, int memberStock);

    Member getMemberEntity(String memberId);

}