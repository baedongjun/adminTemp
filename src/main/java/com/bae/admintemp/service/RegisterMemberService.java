package com.bae.admintemp.service;

import com.bae.admintemp.domain.Member;
import com.bae.admintemp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterMemberService {
    private final MemberRepository repository;

    @Autowired
    public RegisterMemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Long join(String userid, String pw) {
        Member member = Member.createUser(userid, pw);
        validateDuplicateMember(member);
        repository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByUserid(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}