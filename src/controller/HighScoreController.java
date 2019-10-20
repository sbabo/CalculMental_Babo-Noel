package controller;

import bo.Game;
import bo.Player;
import model.ScoreBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (urlPatterns = "/highscore")
public class HighScoreController extends HttpServlet {

    public static final String PAGE_HIGH_SCORE_JSP = "/WEB-INF/jsp/high_score.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ScoreBean model = new ScoreBean();
        HttpSession session = request.getSession( true );
        Player player = (Player)session.getAttribute("isConntected");
        int id = Integer.parseInt(player.getId());
        System.out.println(id);

        List<Game> dataSession = ( List<Game> ) session.getAttribute("scores");
        List<Game> user_highscore = ( List<Game> ) session.getAttribute("highscores");
        if ( null == dataSession ) {
            dataSession = new ArrayList<>();
            user_highscore = new ArrayList<>();
            user_highscore = model.user_highscore(id);
            dataSession = model.highscore();
            for (Game game: dataSession) {
               // System.out.println(game.getScore());
            }
            for (Game game: user_highscore) {
                System.out.println(game.getScore());
            }
            session.setAttribute( "scores", dataSession );
            session.setAttribute("highscores", user_highscore);
        }

        request.getRequestDispatcher(PAGE_HIGH_SCORE_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }


}
