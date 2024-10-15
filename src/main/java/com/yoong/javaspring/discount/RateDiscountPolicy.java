package com.yoong.javaspring.discount;

import com.yoong.javaspring.annotation.MainDiscountPolicy;
import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.enumClass.Grade;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(Member member, int price, int discountAmount) {

        if (member.getGrade() == Grade.VIP) {
            int discountPercent = 10;
            return price * discountPercent / 100;
        }

        return 0;
    }
}
