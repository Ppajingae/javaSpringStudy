package com.yoong.javaspring;

import com.yoong.javaspring.discount.DiscountPolicy;
import com.yoong.javaspring.discount.FixDiscountPolicy;
import com.yoong.javaspring.member.repository.MemberRepository;
import com.yoong.javaspring.member.repository.MemoryMemberRepository;
import com.yoong.javaspring.member.service.MemberService;
import com.yoong.javaspring.member.service.MemberServiceImpl;
import com.yoong.javaspring.order.service.OrderService;
import com.yoong.javaspring.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){

        return new FixDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


}
