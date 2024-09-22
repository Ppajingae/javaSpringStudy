package com.yoong.javaspring.member.repository;


import com.yoong.javaspring.member.entity.Member;

public interface MemberRepository {

    void save(Member member);

    Member findByIdOrNull(Long id);
}
