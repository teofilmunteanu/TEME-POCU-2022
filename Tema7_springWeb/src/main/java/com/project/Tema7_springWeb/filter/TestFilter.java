package com.project.Tema7_springWeb.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(2)
public class TestFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(UserFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) throws IOException, ServletException {
        logger.info("Second filter");
        filterchain.doFilter(request, response);
    }
}
