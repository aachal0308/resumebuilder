package com.ashv.ats.resumebuilder.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class LoggingInterceptor implements HandlerInterceptor {
        private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            long startTime = System.currentTimeMillis();
            request.setAttribute("startTime", startTime);
            logger.info("🚀 Incoming Request: [{}] {} | Headers: {}", request.getMethod(), request.getRequestURI(), request.getHeaderNames());
            return true;
        }
        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            long startTime = (Long) request.getAttribute("startTime");
            long duration = System.currentTimeMillis() - startTime;
            logger.info("✅ Response: [{}] {} | Status: {} | Duration: {}ms", request.getMethod(), request.getRequestURI(), response.getStatus(), duration);
        }
}
