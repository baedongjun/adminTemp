package com.bae.admintemp.data.handler.impl;


import com.bae.admintemp.data.dao.MemberDAO;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.data.handler.MemberDataHandler;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberDataHandlerImpl implements MemberDataHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(MemberDataHandlerImpl.class);

    MemberDAO memberDAO;

    @Autowired
    public MemberDataHandlerImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public Member saveMemberEntity(String userId, String userPw, String userName, String mobile, String email,
                                   Date expirationAt, Date secessionAt, String secessionReason, String roles, List<Board> list) {

        LOGGER.debug("[saveMemberEntity] 매개변수를 통해 Entity 객체 생성");
        Member member = new Member(userId, userPw, userName, mobile, email, expirationAt, secessionAt, secessionReason, roles, list);

        LOGGER.info("[saveMemberEntity] memberDAO로 Member 정보 저장 요청. userId : {}", userId);
        return memberDAO.saveMember(member);
    }

    @Override
    public Member getMemberEntity(String userId) {
        LOGGER.info("[saveMemberEntity] memberDAO로 Member 정보 요청. userId : {}", userId);
        return memberDAO.getMember(userId);
    }

    @Override
    public Optional<Member> findOne(String userId) {
        return memberDAO.findOne(userId);
    }


}