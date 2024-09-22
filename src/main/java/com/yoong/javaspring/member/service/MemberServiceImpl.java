package com.yoong.javaspring.member.service;

import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.repository.MemberRepository;
import com.yoong.javaspring.member.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findByMember(Long id) {
        return memberRepository.findByIdOrNull(id);
    }
}
