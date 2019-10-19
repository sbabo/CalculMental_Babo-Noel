package bo;

import java.io.Serializable;
import java.util.Date;

public class Game implements Serializable {

    private String pseudo;
    private int score;
    private Date date;

    public Game() {
    }

    public Game(String pseudo, int score, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
