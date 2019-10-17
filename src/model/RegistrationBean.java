package model;

import bo.Player;
import dal.DAOFactory;
import dal.PlayerDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;

public class RegistrationBean implements Serializable {

    private static final String FORM_FIELD_NAME = "form-name";
    private static final String FORM_FIELD_LOGIN = "form-login";
    private static final String FORM_FIELD_PWD = "form-pwd";
    public static final String ATT_INSC_SESSION = "estInscrit";


    private String name;
    private String login;
    private String password;
    private String registerResult;

    public void register(HttpServletRequest req) {

        name = req.getParameter(FORM_FIELD_NAME);
        login = req.getParameter(FORM_FIELD_LOGIN);
        password = req.getParameter(FORM_FIELD_PWD);

        PlayerDAO dao = ( PlayerDAO ) DAOFactory.getPlayerDAO();
        Player player = null;

        try {
            player = dao.register(name, login, password);
            if ( player != null ) {
                HttpSession session = req.getSession( true );
                session.setAttribute( ATT_INSC_SESSION, player );
                registerResult = "Inscription réussie !";
            } else {
                registerResult = "Inscription échouée !";

            }
        } catch ( SQLException e ) {
            System.out.println(e.getMessage());
            registerResult = "Inscription échouée : Pb de connexion à la base de données !!! ";
        }

    }

    public boolean estInscrit( HttpServletRequest request ) {
        HttpSession session = request.getSession();
        Player connectedUser = ( Player ) session.getAttribute( ATT_INSC_SESSION );
        return connectedUser != null;
    }
    public String getRegisterResult() {
        return registerResult;
    }

    public void setRegisterResult(String registerResult) {
        this.registerResult = registerResult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
