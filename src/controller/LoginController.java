package controller;

import model.LoginBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( urlPatterns = {"/login"} )
public class LoginController extends HttpServlet {

    private static final String PAGE_LOGIN_JSP = "/WEB-INF/jsp/login.jsp";
    private static final String PAGE_HOME_JSP = "/highscore";

    private int id = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginBean model = new LoginBean();
        HttpSession session = request.getSession( true );

        session.setAttribute("id", id);
        //int id = 1;
        //request.setAttribute("id", id);
        if ( model.isConnected(request) ) {
            response.sendRedirect(request.getContextPath() + PAGE_HOME_JSP);
//            request.getRequestDispatcher("/WEB-INF/jsp/high_score.jsp").forward(request, response);

//            this.getServletContext().getRequestDispatcher( "/highscore" ).forward( request, response );

        } else {
            request.getRequestDispatcher(PAGE_LOGIN_JSP).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginBean model = new LoginBean();
        model.authenticate(request);
        request.setAttribute("loginBean", model);
        doGet(request, response);
    }
}