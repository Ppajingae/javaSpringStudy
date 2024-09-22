package com.yoong.javaspring.member.service;


import com.yoong.javaspring.member.entity.Member;

public interface MemberService {

    void join(Member member);

    Member findByMember(Long id);
}
