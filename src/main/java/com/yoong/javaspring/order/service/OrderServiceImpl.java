package com.yoong.javaspring.order.service;

import com.yoong.javaspring.discount.DiscountPolicy;
import com.yoong.javaspring.discount.FixDiscountPolicy;
import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.enumClass.Grade;
import com.yoong.javaspring.member.repository.MemberRepository;
import com.yoong.javaspring.member.repository.MemoryMemberRepository;
import com.yoong.javaspring.order.entity.Order;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
