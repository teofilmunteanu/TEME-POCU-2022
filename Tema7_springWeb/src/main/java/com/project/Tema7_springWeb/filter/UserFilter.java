package com.project.Tema7_springWeb.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
@WebFilter("/users")
public class UserFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(UserFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        logger.info("Request URI: " + req.getRequestURI());
        filterchain.doFilter(req, res);
        logger.info("Response Status: " + res.getStatus());
    }
}
