package model;

import bo.Game;
import dal.DAOFactory;
import dal.GameDAO;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class ScoreBean implements Serializable {

    public List<Game> highscore() {
        GameDAO dao = ( GameDAO ) DAOFactory.getGameDAO();
        List<Game> highscore = null;
        try {
            highscore = dao.highscore();

            if ( highscore.size() <= 0 ) {
                System.out.println("Récupération des highscores échouée !");
            } else {
                System.out.println("Récupération des highscores réussie !");
            }
        } catch ( SQLException e ) {
            System.out.println(e.getMessage());
            System.out.println("Récupération des highscores échouée : Pb de connexion à la base de données !!! ");
        }
        return highscore;
    }
}
