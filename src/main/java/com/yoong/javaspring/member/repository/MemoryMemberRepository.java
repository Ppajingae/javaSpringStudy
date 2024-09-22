package com.yoong.javaspring.member.repository;

import com.yoong.javaspring.member.entity.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findByIdOrNull(Long id) {
        return store.get(id);
    }
}
