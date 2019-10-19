package controller;

import model.RegistrationBean;

import javax.servlet.Registration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "RegisterController", urlPatterns = {"/register"} )
public class RegisterController extends HttpServlet {

    private static final String PAGE_REGISTER_JSP = "/WEB-INF/jsp/register.jsp";
    private static final String PAGE_LOGIN_JSP = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RegistrationBean model = new RegistrationBean();
        if ( model.estInscrit(req) ) {
            resp.sendRedirect(req.getContextPath() + PAGE_LOGIN_JSP);
        } else {
            req.getRequestDispatcher(PAGE_REGISTER_JSP).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegistrationBean register = new RegistrationBean();
        register.register(req);
        System.out.println(register.toString());
        req.setAttribute("registrationBean", register);
        doGet(req, resp);

    }
}
