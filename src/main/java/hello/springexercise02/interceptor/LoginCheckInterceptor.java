package hello.springexercise02.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // request url
        String requestURI = request.getRequestURI();
        // session 확인
        HttpSession session = request.getSession();
        if(session == null || session.getAttribute("sessionId") == null){
            log.info("미인증 사용자 요청");
            response.sendRedirect("/login?redirectURL="+requestURI);
            return false;
        }
        return true;
    }
}
