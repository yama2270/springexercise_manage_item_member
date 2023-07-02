package hello.springexercise02.service.login;

import hello.springexercise02.domain.LoginForm;
import hello.springexercise02.domain.Member;
import hello.springexercise02.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberMapper memberMapper;

    public Member login(LoginForm loginForm){
        Member loginMember = memberMapper.findByLoginIdMember(loginForm.getLoginId());
        return loginMember;
    }

}
