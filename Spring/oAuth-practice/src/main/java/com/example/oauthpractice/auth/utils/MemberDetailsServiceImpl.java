package com.example.oauthpractice.auth.utils;

import com.example.oauthpractice.exception.BusinessLogicException;
import com.example.oauthpractice.exception.ExceptionCode;
import com.example.oauthpractice.security.MemberDetailsImpl;
import com.example.oauthpractice.user.entity.Member;
import com.example.oauthpractice.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        //UserDetailsImpl에서 정의한 생성자
        return new MemberDetailsImpl(member);
    }
}
