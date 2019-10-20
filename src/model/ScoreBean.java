package model;

import bo.Game;
import dal.DAOFactory;
import dal.GameDAO;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class ScoreBean implements Serializable {

    /**
     * Permet de récupérer les meilleurs scores pour les affichers dans un tableau
     * @return List<Game>
     */
    public List<Game> highscore() {
        GameDAO dao = ( GameDAO ) DAOFactory.getGameDAO();
        List<Game> highscore = null;
        try {
            highscore = dao.highscore(); // demande a la dao de rechercher en base les inforamtions

            if ( highscore.size() <= 0 ) { //si des scores sont remontés
                System.out.println("Récupération des highscores échouée !");
            } else {
                System.out.println("Récupération des highscores réussie !");
            }
        } catch ( SQLException e ) { // en cas d'erreur SQL
            System.out.println(e.getMessage());
            System.out.println("Récupération des highscores échouée : Pb de connexion à la base de données !!! ");
        }
        return highscore;
    }

    /**
     * Permet de récuperer le meilleur score du joueur connecté
     * @param id id
     * @return list<Game>
     */
    public List<Game> user_highscore(int id) {
        GameDAO dao = ( GameDAO ) DAOFactory.getGameDAO();
        List<Game> highscore = null;
        try {
            highscore = dao.highscore_user(id); // interogation de la dao

            if ( highscore.size() <= 0 ) { // Si au moins une game est remontée
                System.out.println("Récupération des highscores échouée !");
            } else {
                System.out.println("Récupération des highscores réussie !");
            }
        } catch ( SQLException e ) { // en cas d'erreur SQL
            System.out.println(e.getMessage());
            System.out.println("Récupération des highscores échouée : Pb de connexion à la base de données !!! ");
        }
        return highscore;
    }
}
