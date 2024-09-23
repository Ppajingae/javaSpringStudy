package com.yoong.javaspring;

import com.yoong.javaspring.discount.FixDiscountPolicy;
import com.yoong.javaspring.member.repository.MemoryMemberRepository;
import com.yoong.javaspring.member.service.MemberService;
import com.yoong.javaspring.member.service.MemberServiceImpl;
import com.yoong.javaspring.order.service.OrderService;
import com.yoong.javaspring.order.service.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
