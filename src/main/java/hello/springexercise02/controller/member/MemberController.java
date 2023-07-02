package hello.springexercise02.controller.member;

import hello.springexercise02.domain.Member;
import hello.springexercise02.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @GetMapping("/add")
    public String addMemberForm(Member member , Model model){
        model.addAttribute("member",member);
        return "member/addMemberForm";
    }

    @PostMapping("/add")
    public String addMember(Member member) {
        memberService.saveMember(member);
        return "redirect:/";
    }

}
