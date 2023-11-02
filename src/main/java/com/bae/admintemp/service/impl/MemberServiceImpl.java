package com.bae.admintemp.service.impl;

import com.bae.admintemp.data.dto.MemberDto;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.data.handler.MemberDataHandler;
import com.bae.admintemp.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    MemberDataHandler memberDataHandler;

    @Autowired
    public MemberServiceImpl(MemberDataHandler memberDataHandler) {
        this.memberDataHandler = memberDataHandler;
    }

    @Override
    public MemberDto saveMember(String userId, String userPw, String userName, String mobile, String email,
                                Date createAt, Date updateAt, Date expirationAt, Date secessionAt,
                                String secessionReason, String roles, List<Board> list) {

        LOGGER.info("[saveMember] memberDataHandler 로 상품 정보 저장 요청");
        Member member = memberDataHandler.saveMemberEntity(userId, userPw, userName, mobile, email, createAt, updateAt,
                expirationAt, secessionAt, secessionReason, roles, list);

        LOGGER.info("[saveMember] Entity 객체를 DTO 객체로 변환 작업. userId : {}", member.getUserId());
        MemberDto memberDto = new MemberDto(member.getUserId(), member.getUserPw(), member.getUserName(),
                member.getMobile(), member.getEmail(), member.getCreateAt(), member.getUpdateAt(),
                member.getExpirationAt(), member.getSecessionAt(), member.getSecessionReason(), member.getRoles(), member.getList()
        );

        return memberDto;
    }

    @Override
    public MemberDto getMember(String userId) {

        LOGGER.info("[getMember] memberDataHandler 로 상품 정보 조회 요청");
        Member member = memberDataHandler.getMemberEntity(userId);

        LOGGER.info("[getMember] Entity 객체를 DTO 객체로 변환 작업. userId : {}",
                member.getUserId());
        MemberDto memberDto = new MemberDto(member.getUserId(), member.getUserPw(), member.getUserName(),
                member.getMobile(), member.getEmail(), member.getCreateAt(), member.getUpdateAt(),
                member.getExpirationAt(), member.getSecessionAt(), member.getSecessionReason(), member.getRoles(), member.getList()
        );

        return memberDto;
    }
}
