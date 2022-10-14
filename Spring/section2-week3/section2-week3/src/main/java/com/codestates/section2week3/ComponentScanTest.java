package com.codestates.section2week3;

import com.codestates.section2week3.member.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DependencyConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println(MemberService.class.isInstance(memberService));
    }
}
