package controller;

import bo.Expression;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet ( name ="gameController", urlPatterns = "/game")
public class GameController extends HttpServlet {

    public static final String PAGE_GAME_JSP = "/WEB-INF/jsp/game.jsp";
    public static final String NEXT = "NEXT";

    private int question = 0;

    private List<String> expression = new ArrayList<>();
    private List<String> questions = new ArrayList<>();
    private List<String> reponses = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (expression.size() == 0) {
            Expression ex = new Expression();
            for (int i = 0; i < 10; i++) {
                expression.add(ex.generateCalcul(3, 10));
                questions.add(ex.generateCalcVisuel(expression.get(i)));
                reponses.add(ex.resolveCalcul(expression.get(i)));
            }
        }
        HttpSession session = req.getSession( true );

        session.setAttribute("questions", questions.get(question));
        session.setAttribute("noquestion", question + 1);
        if (question < 9) {
            session.setAttribute("valeurButton", "NEXT");
        } else {
            session.setAttribute("valeurButton", "Fin de Partie");
        }
        req.getRequestDispatcher(PAGE_GAME_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter( "action" );
        if ( action.equals(NEXT) ) {
            if (question < 9){
                question++;
            }
        }
        doGet(req, resp);
    }
}
