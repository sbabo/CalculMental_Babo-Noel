package controller;

import bo.Game;
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

        List<Game> dataSession = ( List<Game> ) session.getAttribute("scores");

        if ( null == dataSession ) {
            dataSession = new ArrayList<>();
            dataSession = model.highscore();
            for (Game game: dataSession) {
                System.out.println(game.getScore());
            }
            session.setAttribute( "scores", dataSession );
        }

        request.getRequestDispatcher(PAGE_HIGH_SCORE_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }


}
