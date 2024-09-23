package com.yoong.javaspring.order.service;

import com.yoong.javaspring.discount.DiscountPolicy;
import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.repository.MemberRepository;
import com.yoong.javaspring.order.entity.Order;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long id, String itemName, int itemPrice) {


        Member member = memberRepository.findByIdOrNull(id);

        int discount = discountPolicy.discount(member, itemPrice, 2000);

        return new Order(
                1L,
                itemName,
                itemPrice,
                discount
        );
    }
}
