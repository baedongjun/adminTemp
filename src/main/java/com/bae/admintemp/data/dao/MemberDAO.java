package com.bae.admintemp.data.dao;


import com.bae.admintemp.data.entity.Member;

public interface MemberDAO {

    Member saveMember(Member member);

    Member getMember(String userId);

}