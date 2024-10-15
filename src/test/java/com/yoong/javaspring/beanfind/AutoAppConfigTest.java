package com.yoong.javaspring.beanfind;

import com.yoong.javaspring.AutoAppConfigKotlinVer;
import com.yoong.javaspring.member.service.MemberService;
import com.yoong.javaspring.member.service.MemberServiceImpl;
import com.yoong.javaspring.order.service.OrderService;
import com.yoong.javaspring.order.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void autoAppConfig(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfigKotlinVer.class);

        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderService orderService = ac.getBean("orderService", OrderServiceImpl.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
