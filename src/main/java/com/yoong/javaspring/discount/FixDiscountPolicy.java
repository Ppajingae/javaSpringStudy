package com.yoong.javaspring.discount;

import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.enumClass.Grade;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price, int discountAmount) {

        if(discountFixAmount < discountAmount) {
            discountFixAmount = discountAmount;
        }

        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }else return 0;

    }
}
