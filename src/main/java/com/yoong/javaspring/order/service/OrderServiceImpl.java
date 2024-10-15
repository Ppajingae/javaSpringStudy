package com.yoong.javaspring.order.service;

import com.yoong.javaspring.annotation.MainDiscountPolicy;
import com.yoong.javaspring.discount.DiscountPolicy;
import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.repository.MemberRepository;
import com.yoong.javaspring.member.repository.MemoryMemberRepository;
import com.yoong.javaspring.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// @RequiredArgsConstructor final 붙은 변수를 생성자로 만들어준다
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
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

    public MemberRepository getMemoryMemberRepository(){
        return new MemoryMemberRepository();
    }
}
