package ru.icmit.oodb.lab19.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        String path = ((HttpServletRequest)request).getRequestURI();
        if ("/loginpage".equals(path) || "/login".equals(path)) {
            System.out.println("detected login pages");
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession session = ((HttpServletRequest)request).getSession(false);
        if (session != null) {
            System.out.println("autentificated user");
            filterChain.doFilter(request, response);
            return;
        } else {
            System.out.println("redirected to login page");
            ((HttpServletResponse) response).sendRedirect("/loginpage");
        }
    }

    @Override
    public void destroy() {

    }
}
