package hello.springexercise02.service.member;

import hello.springexercise02.domain.Member;
import hello.springexercise02.mapper.member.MemberMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    void saveMember() {
        Member member = new Member(2L,"member","멤버","member");
        memberMapper.saveMember(member);
        Member saveMember = memberMapper.findByLoginIdMember(member.getLoginId());
        System.out.println("saveMember = " + saveMember);
    }
}