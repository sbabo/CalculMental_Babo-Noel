package controller;

import bo.Game;
import bo.Player;
import model.GameBean;
import model.ScoreBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet (urlPatterns = "/highscore")
public class HighScoreController extends HttpServlet {
    public static final String PAGE_GAME_JSP = "/game";
    public static final String NEXT = "NEXT";
    public static final String REPONSE = "form-reponse";
    public static final String NEWGAME = "form-game";

    private int question = 0;
    private String game = "";

    private List<String> expression = new ArrayList<>();
    private List<String> questions = new ArrayList<>();
    private List<String> reponses = new ArrayList<>();

    public static final String PAGE_HIGH_SCORE_JSP = "/WEB-INF/jsp/high_score.jsp";

    /**
     * DoGet HighScoreController
     * @param request req
     * @param response resp
     * @throws ServletException Servlet excep
     * @throws IOException IOExcep
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ScoreBean model = new ScoreBean();
        HttpSession session = request.getSession( true );
        Player player = (Player)session.getAttribute("isConntected");
        int id = Integer.parseInt(player.getId());

        List<Game> dataSession = ( List<Game> ) session.getAttribute("scores");
        List<Game> user_highscore = ( List<Game> ) session.getAttribute("highscores");
        //Recherche des meilleurs score pour afficher dans le tableau
        if ( null == dataSession ) {
            dataSession = new ArrayList<>();
            user_highscore = new ArrayList<>();
            user_highscore = model.user_highscore(id);
            dataSession = model.highscore();
            session.setAttribute( "scores", dataSession );
            session.setAttribute("highscores", user_highscore);
        }

        request.getRequestDispatcher(PAGE_HIGH_SCORE_JSP).forward(request, response);
    }

    /**
     * DoPost HighScoreController
     * @param request req
     * @param response resp
     * @throws ServletException Servlet Exception
     * @throws IOException IOExeption
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter( "action" );
        //Redirection vers la page Game si on clique sur le bouton nouvelle partie
        game = request.getParameter(NEWGAME);
        response.sendRedirect(request.getContextPath() + PAGE_GAME_JSP);
    }


}
