package com.yoong.javaspring;

import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.enumClass.Grade;
import com.yoong.javaspring.member.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member kim = new Member(1L, "kim", Grade.VIP);

        memberService.join(kim);

        Member getMember = memberService.findByMember(1L);

        System.out.println(getMember.toString());

    }
}
