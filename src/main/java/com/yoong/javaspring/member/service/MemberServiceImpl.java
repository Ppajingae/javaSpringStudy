package com.yoong.javaspring.member.service;

import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findByMember(Long id) {
        return memberRepository.findByIdOrNull(id);
    }

}
