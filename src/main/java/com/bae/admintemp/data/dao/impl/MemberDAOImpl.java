package com.bae.admintemp.data.dao.impl;

import com.bae.admintemp.data.dao.MemberDAO;
import com.bae.admintemp.data.dto.MemberDto;
import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.data.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberDAOImpl implements MemberDAO {

    private final Logger LOGGER = LoggerFactory.getLogger(MemberDAOImpl.class);

    MemberRepository memberRepository;

    @Autowired
    public MemberDAOImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member saveMember(Member member) {
        LOGGER.info("[saveMember] member 정보 저장. userId : {}", member.getUserId());
        Member member1 = memberRepository.save(member);
        LOGGER.info("[saveMember] member 정보 저장완료. userId : {}", member1.getUserId());
        return member1;
    }

    @Override
    public Member getMember(String userId) {
        LOGGER.info("[getMember] member 정보 요청. userId : {}", userId);
        Member member = memberRepository.getById(userId);
        LOGGER.info("[getMember] member 정보 요청 완료. userId : {}", member.getUserId());
        return member;
    }

    @Override
    public Optional<Member> findOne(String userId) {
        return memberRepository.findByUserId(userId);
    }

    /**
     * Repository에서 기본적으로 제공하는 대표적인 메소드
     */
    private void testRepositoryMethod() {
/*    memberRepository.save();
    memberRepository.getById();
    memberRepository.delete();
    memberRepository.deleteAll();
    memberRepository.findAll();
    memberRepository.saveAll();*/
    }
}