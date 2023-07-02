package hello.springexercise02.controller.login;

import hello.springexercise02.domain.LoginForm;
import hello.springexercise02.domain.Member;
import hello.springexercise02.service.login.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String loginForm(Model model){
        model.addAttribute("loginForm",new LoginForm());
        return "login/loginForm";
    }

    @PostMapping
    public String login(LoginForm loginForm, HttpServletRequest request){
        Member member = loginService.login(loginForm);
        if(member == null){
            return "login/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("sessionId", member);
        return "redirect:/items";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/";
    }

}
