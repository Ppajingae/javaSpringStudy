package com.yoong.javaspring;

import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.enumClass.Grade;
import com.yoong.javaspring.member.service.MemberService;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();

        Member kim = new Member(1L, "Kim", Grade.BASIC);

        memberService.join(kim);

        Member getMember = memberService.findByMember(1L);

        System.out.println("kim : " + kim.getName());
        System.out.println("id : " + getMember.getId());
        System.out.println("name : " + getMember.getName());
        System.out.println("grade : " + getMember.getGrade());

    }
}
