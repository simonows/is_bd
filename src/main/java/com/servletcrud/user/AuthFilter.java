package com.servletcrud.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthFilter implements Filter
{
    private FilterConfig config = null;
    private boolean active = false;

    public void init(FilterConfig config) throws ServletException
    {
        this.config = config;
        String act = config.getInitParameter("active");
        if (act != null) {
            active = (act.toUpperCase().equals("TRUE"));
        }
    }

    public void doFilter(
        ServletRequest request
      , ServletResponse response
      , FilterChain chain
    )throws IOException, ServletException {
        String url = ((HttpServletRequest)request).getRequestURL().toString();

        HttpSession session = ((HttpServletRequest) request).getSession();
        String login = (String)session.getAttribute("name");

        if (login != null) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendRedirect("regauth");
        }
    }

    public void destroy()
    {
        config = null;
    }
}