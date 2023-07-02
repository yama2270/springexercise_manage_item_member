package hello.springexercise02.service.member;

import hello.springexercise02.domain.Member;
import hello.springexercise02.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void saveMember(Member member){
        memberMapper.saveMember(member);
    }

    public Member findByLoginIdMember(String loginId){
        return memberMapper.findByLoginIdMember(loginId);
    }

}
