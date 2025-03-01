package com.ashv.ats.resumebuilder.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Checking authentication for request: {}", request.getRequestURI());

        // Example: Check for a token in headers
        String sessionId = request.getHeader("session");

        if (authToken == null || !SessionManagerUtil.validateSessionId(sessionId)) { 
            logger.warn("Unauthorized request to {}", request.getRequestURI());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized Access");
            return false;
        }
        return true;
    }
}
