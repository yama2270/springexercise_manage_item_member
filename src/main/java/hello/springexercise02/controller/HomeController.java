package hello.springexercise02.controller;

import hello.springexercise02.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@SessionAttribute(name="sessionId",required = false) Member member){
        if(member == null){
            return "home";
        }
        return "redirect:/items";
    }

}
