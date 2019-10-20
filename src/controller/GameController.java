package controller;

import bo.Expression;
import bo.Player;
import model.GameBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet ( name ="gameController", urlPatterns = "/game")
public class GameController extends HttpServlet {

    public static final String PAGE_GAME_JSP = "/WEB-INF/jsp/game.jsp";
    public static final String PAGE_HIGHSCORE_JSP = "/highscore";
    public static final String NEXT = "NEXT";
    public static final String REPONSE = "form-reponse";

    private int question = 0;
    private String reponse = "";

    private List<String> expression = new ArrayList<>();
    private List<String> questions = new ArrayList<>();
    private List<String> reponses = new ArrayList<>();

    private int score = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (question > 9) {
            resp.sendRedirect(req.getContextPath() + PAGE_HIGHSCORE_JSP);
        }
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
        session.setAttribute("rep", reponses.get(question));
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
        HttpSession session = req.getSession( true );
        reponse = req.getParameter(REPONSE);
        if ( action.equals(NEXT) ) {
            if (question < 9){
                if (reponse.equals(reponses.get(question))) {
                    score++;
                }
                question++;
            } else {
                if (reponse.equals(reponses.get(question))) {
                    score++;
                    req.setAttribute("form-score", score);
                }
                Player player = (Player)session.getAttribute("isConntected");
                int id = Integer.parseInt(player.getId());
                String pseudo = player.getPseudo();
                GameBean gameBean = new GameBean();
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dateDujour = sdf.format(date);
                // TODO renseigner les idplayer, pseudo
                gameBean.enregistrerScore(id,player.getPseudo(),score,dateDujour);
                req.getRequestDispatcher("/WEB-INF/jsp/high_score.jsp").forward(req, resp);
            }
        }
        doGet(req, resp);
    }
}
