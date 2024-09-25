package com.yoong.javaspring;

import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.enumClass.Grade;
import com.yoong.javaspring.member.service.MemberService;
import com.yoong.javaspring.order.entity.Order;
import com.yoong.javaspring.order.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

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
