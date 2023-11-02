package com.bae.admintemp.data.dao;


import com.bae.admintemp.data.dto.MemberDto;
import com.bae.admintemp.data.entity.Member;

import java.util.Optional;

public interface MemberDAO {

    Member saveMember(Member member);

    Member getMember(String userId);

    Optional<Member> findOne(String userId);

}