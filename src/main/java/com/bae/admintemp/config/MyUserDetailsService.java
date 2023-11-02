package com.bae.admintemp.config;

import com.bae.admintemp.data.dto.MemberDto;
import com.bae.admintemp.service.MemberService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {
    private final MemberService memberService;

    public MyUserDetailsService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
        MemberDto findOne = memberService.getMember(insertedUserId);
//        MemberDto memberDto = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        return User.builder()
                .username(findOne.getUserId())
                .password(findOne.getUserPw())
                .roles(findOne.getRoles())
                .build();
    }
}
