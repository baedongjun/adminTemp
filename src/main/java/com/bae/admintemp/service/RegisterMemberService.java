package com.bae.admintemp.service;

import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.data.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterMemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository repository;

    @Autowired
    public RegisterMemberService(PasswordEncoder passwordEncoder, MemberRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    public String join(String userId, String userPw) {
        Member member = new Member();
        member.setUserId(userId);
        member.setUserPw(passwordEncoder.encode(userPw));
        member.setRoles("USER");
        validateDuplicateMember(member);
        repository.save(member);

        return member.getUserId();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByUserId(member.getUserId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}