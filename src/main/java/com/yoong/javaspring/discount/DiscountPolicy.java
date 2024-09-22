package com.yoong.javaspring.discount;

import com.yoong.javaspring.member.entity.Member;

public interface DiscountPolicy {

    int discount(Member member, int price, int discountAmount);
}
