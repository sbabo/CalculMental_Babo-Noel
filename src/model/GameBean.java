package model;

import bo.Game;
import dal.DAOFactory;
import dal.GameDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Date;
import java.sql.SQLException;

public class GameBean implements Serializable {

    private static final String FORM_FIELD_IDPLAYER = "form-idplayer";
    private static final String FORM_FIELD_LOGIN = "form-login";
    private static final String FORM_FIELD_SCORE = "form-score";

    private String idplayer;
    private String pseudo;
    private String score;
    private String date;

    public void enregistrerScore(String idplayer, String pseudo, String score, String date) {

        this.idplayer = idplayer;
        this.pseudo = pseudo;
        this.score = score;
        this.date = date;
        GameDAO dao = ( GameDAO ) DAOFactory.getGameDAO();
        Game game = null;
        try {
            game = dao.enregister(idplayer, pseudo, score, date);
            if ( game != null ) {
                System.out.println("Inscription réussie !");
            } else {
                System.out.println("Inscription échouée !");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getIdplayer() {
        return idplayer;
    }

    public void setIdplayer(String idplayer) {
        this.idplayer = idplayer;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
