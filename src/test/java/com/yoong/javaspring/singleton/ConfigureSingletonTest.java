package com.yoong.javaspring.singleton;

import com.yoong.javaspring.AppConfig;
import com.yoong.javaspring.member.repository.MemberRepository;
import com.yoong.javaspring.member.service.MemberServiceImpl;
import com.yoong.javaspring.order.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigureSingletonTest {

    @Test
    void configurationTest(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemoryMemberRepository();
        MemberRepository memberRepository2 = memberService.getMemoryMemberRepository();

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig config = ac.getBean(AppConfig.class);

        System.out.println("config = " + config.getClass());
    }
}
