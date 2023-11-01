package com.bae.admintemp.service;

import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.data.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<Member> findOne(String userId) {
        return memberRepository.findByUserId(userId);
    }
}