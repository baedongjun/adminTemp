package com.bae.admintemp.data.handler.impl;


import com.bae.admintemp.data.dao.MemberDAO;
import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.data.handler.MemberDataHandler;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public Member saveMemberEntity(int userId, String userPw, String userName, String mobile, String email, Date createAt, Date updateAt, Date expirationAt, Date secessionAt, String secessionReason, String roles) {

        LOGGER.debug("[saveProductEntity] 매개변수를 통해 Entity 객체 생성");
        Member member = new Member(userId, userPw, userName, mobile, email, createAt, updateAt, expirationAt, secessionAt, secessionReason, roles);

        LOGGER.info("[saveMemberEntity] memberDAO로 Member 정보 저장 요청. memberId : {}", userId);
        return memberDAO.saveMember(member);
    }

    @Override
    public Member getMemberEntity(String userId) {
        LOGGER.info("[saveMemberEntity] memberDAO로 Member 정보 요청. memberId : {}", userId);
        return memberDAO.getMember(userId);
    }
}