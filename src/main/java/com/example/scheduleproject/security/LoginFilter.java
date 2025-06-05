package com.example.scheduleproject.security;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;


public class LoginFilter implements Filter {
    // 인증을 하지 않아도 될 URL Path 배열
    private static final String[] WHITE_LIST = {"/", "*/signup", "*/login", "*/logout"};

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException{

        // 다양한 기능을 사용하기 위한 다운캐스팅
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        // 로그인을 체크 해야하는 URL 인지 검사
        // whiteListURL에 포함되는 경우 true 반환 -> !true = false
        if(!isWhiteList(requestURI)){
            // 로그인 확인 -> 로그인 하면 session에 값이 저장되어 있다는 가정
            // 세션이 존재하면 가져온다.
            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute("user") == null ){
                throw new AuthenticationException("로그인 해 주세요.");
            }
        }

        chain.doFilter(request, response);

    }

    private boolean isWhiteList(String requestURI){
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }

}
