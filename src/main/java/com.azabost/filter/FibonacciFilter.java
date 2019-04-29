package com.azabost.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        filterName = "FibonacciFilter",
        urlPatterns = {"/fibonacci"}
)
public class FibonacciFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getParameter("result") != null && !servletRequest.getParameter("result").isEmpty()) {
            String result = servletRequest.getParameter("result");
            try {
                Integer.valueOf(servletRequest.getParameter("result"));
            } catch (NumberFormatException e) {
                servletRequest.setAttribute("result", "Bad parameter");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
