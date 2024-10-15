package com.yoong.javaspring.beanfind;

import com.yoong.javaspring.AppConfig;
import com.yoong.javaspring.member.service.MemberService;
import com.yoong.javaspring.member.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름 으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        Assertions.assertThat(MemberService.class).isInstanceOf(MemberServiceImpl.class);
        
    }
}
