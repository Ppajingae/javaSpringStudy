package com.yoong.javaspring.member.service;

import com.yoong.javaspring.member.entity.Member;
import com.yoong.javaspring.member.repository.MemberRepository;
import com.yoong.javaspring.member.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findByMember(Long id) {
        return memberRepository.findByIdOrNull(id);
    }

    public MemberRepository getMemoryMemberRepository(){
        return new MemoryMemberRepository();
    }
}
