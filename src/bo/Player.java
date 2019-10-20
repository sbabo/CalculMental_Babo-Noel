package bo;

import java.io.Serializable;

public class Player implements Serializable {

    private String id;
    private String pseudo;
    private String login;
    private String password;

    /**
     * Constructeur par défaut
     */
    public Player() {
    }

    /**
     * Constructeur de base
     * @param pseudo pseudo
     * @param login login
     * @param password password
     */
    public Player(String pseudo, String login, String password) {
        this.pseudo = pseudo;
        this.login = login;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
