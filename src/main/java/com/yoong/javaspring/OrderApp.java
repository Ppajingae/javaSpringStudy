package com.yoong.javaspring;

import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.enumClass.Grade;
import com.yoong.javaspring.member.service.MemberService;
import com.yoong.javaspring.order.entity.Order;
import com.yoong.javaspring.order.service.OrderService;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long member1Id = 1L;
        Long member2Id = 2L;

        Member member1 = new Member(member1Id, "Kim", Grade.VIP);
        Member member2 = new Member(member2Id, "Lee", Grade.BASIC);

        memberService.join(member1);
        memberService.join(member2);

        Order order1 = orderService.createOrder(member1Id, "itemA", 20000);
        Order order2 = orderService.createOrder(member2Id, "itemA", 20000);

        System.out.println("order1 = " + order1.toString());
        System.out.println("order2 = " + order2.toString());

    }
}
