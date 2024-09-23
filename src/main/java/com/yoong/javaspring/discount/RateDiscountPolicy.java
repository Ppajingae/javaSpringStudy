package com.yoong.javaspring.discount;

import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.enumClass.Grade;

public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price, int discountAmount) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }

        return 0;
    }
}
