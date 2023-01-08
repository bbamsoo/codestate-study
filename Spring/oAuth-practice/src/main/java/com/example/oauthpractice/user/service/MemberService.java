package com.example.oauthpractice.user.service;

import com.example.oauthpractice.exception.BusinessLogicException;
import com.example.oauthpractice.exception.ExceptionCode;
import com.example.oauthpractice.user.dto.LoginDto;
import com.example.oauthpractice.user.entity.Member;
import com.example.oauthpractice.user.entity.MemberRoles;
import com.example.oauthpractice.user.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String ADMIN_PW = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    public Member createMember(Member memberDto) {
        String email = memberDto.getEmail();

        // 회원 ID 중복 확인
        Optional<Member> findMember = memberRepository.findByEmail(email);
        if (findMember.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
        }

        String nickname = memberDto.getNickname();

        //패스워드 암호화
        String password = passwordEncoder.encode(memberDto.getPassword());

        // 사용자 ROLE 확인
        MemberRoles role = MemberRoles.ROLE_MEMBER;
        //true면 == 관리자이면
//        if (memberDto.isAdmin()) {
//            if (!memberDto.getAdminToken().equals(ADMIN_PW)) {
//                throw new BusinessLogicException(ExceptionCode.ADMIN_TOKEN);
//            }
//            //role을 admin으로 바꿔준다
//            role = MemberRoles.ROLE_ADMIN;
//        }

        Member member = new Member(email, nickname, password, role);
        return memberRepository.save(member);
    }

    //로그인
    public Member login(LoginDto loginUserDto) {
        Member member = memberRepository.findByEmail(loginUserDto.getEmail()).orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        if (!passwordEncoder.matches(loginUserDto.getPassword(), member.getPassword())) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
        }
        return member;
    }
}
