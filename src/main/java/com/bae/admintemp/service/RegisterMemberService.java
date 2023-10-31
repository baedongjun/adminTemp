package com.bae.admintemp.service;

import com.bae.admintemp.domain.Member;
import com.bae.admintemp.repository.MemberRepository;
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

    public String join(String userid, String pw) {
        Member member = new Member();
        member.setUserid(userid);
        member.setPw(passwordEncoder.encode(pw));
        member.setRoles("USER");
        validateDuplicateMember(member);
        repository.save(member);

        return member.getUserid();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByUserid(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}