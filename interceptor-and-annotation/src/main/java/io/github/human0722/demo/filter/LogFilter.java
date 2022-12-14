package io.github.human0722.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * @author xueliang
 * @date 2022-12-13 15:43
 */
@Component
public class LogFilter extends OncePerRequestFilter {
    private Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Hello from:" + request.getRemoteAddr());
        String token = request.getHeader("token");
        if (!StringUtils.hasLength(token)) {
            response.reset();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            log.error("Message from LogFilter: 没有token");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
