package com.yoong.javaspring.member

import com.yoong.javaspring.member.entity.Member
import com.yoong.javaspring.member.enumClass.Grade
import com.yoong.javaspring.member.service.MemberServiceImpl
import io.kotest.core.spec.style.Test
import io.kotest.matchers.shouldBe


class MemberServiceTest(
    private val memberService: MemberServiceImpl
){


    @Test
    fun `맴버 값이 잘 나오는지 확인`(){
        //given
        val member = Member(
            1L,
            "kim",
            Grade.BASIC
        )

        //when
        memberService.join(member)
        val getMember = memberService.findByMember(1L)

        //then
        getMember.id shouldBe 2L
        getMember.name shouldBe "kim"
        getMember.grade shouldBe Grade.BASIC
    }
}