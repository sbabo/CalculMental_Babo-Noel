package bo;

import java.io.Serializable;
import java.util.Date;

public class Game implements Serializable {

    private String pseudo;
    private int score;
    private String date;

    public Game() {
    }

    public Game(String pseudo, int score, String date) {
        this.pseudo = pseudo;
        this.score = score;
        this.date = date;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
