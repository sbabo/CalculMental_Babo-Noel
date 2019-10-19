package filter;

import model.LoginBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter (urlPatterns ="/highscore")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //TODO A completer quand on aura les différentes pages de redirection
        HttpSession session = ((HttpServletRequest)servletRequest).getSession(  );
        if ( null == session || null == session.getAttribute( LoginBean.ATT_AUTH_SESSION )) {
            ((HttpServletRequest)servletRequest).getRequestDispatcher( "login" ).forward( servletRequest, servletResponse );
        } else {
            filterChain.doFilter( servletRequest, servletResponse );
        }
    }

    @Override
    public void destroy() {

    }
}
