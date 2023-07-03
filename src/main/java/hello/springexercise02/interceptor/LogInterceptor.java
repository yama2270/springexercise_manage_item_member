package hello.springexercise02.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // uuid
        String uuid = UUID.randomUUID().toString();
        request.setAttribute("logId", uuid);
        // request url
        String requestURI = request.getRequestURI();
        // handler
        if(handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;
        }
        log.info("REQUEST - [{}][{}][{}]",uuid,requestURI,handler);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // uuid
        String uuid = (String)request.getAttribute("logId");
        // request url
        String requestURI = request.getRequestURI();
        log.info("RESPONSE - [{}][{}]",uuid,requestURI);
        if (ex != null) {
            log.info("error 발생 - [{}]",ex);
        }
    }
}
