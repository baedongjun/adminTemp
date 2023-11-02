package com.bae.admintemp.data.repository;

import com.bae.admintemp.data.dto.MemberDto;
import com.bae.admintemp.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByUserId(String userId);
}