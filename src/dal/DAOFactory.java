package dal;

import bo.Player;

import javax.servlet.ServletContext;

public class DAOFactory {
    private static String mode;
    private static String dbUrl;
    private static String dbLogin;
    private static String dbPwd;

    public static void init (ServletContext context ) throws ClassNotFoundException {
        mode = context.getInitParameter("DS_MODE");
        switch ( mode ) {
            case "JDBC" :
                Class.forName( context.getInitParameter( "DB_DRIVER" ) );
                dbUrl = context.getInitParameter( "DB_URL" );
                dbLogin = context.getInitParameter( "DB_LOGIN" );
                dbPwd = context.getInitParameter( "DB_PWD" );
                break;
            case "JPA": break;
            default:
                //TODO
        }
    }

    public static IDAO<Player> getPlayerDAO() {
        IDAO<Player> dao = null;
        switch ( mode ) {
            case "JDBC" :
                dao = new PlayerDAO(dbUrl, dbLogin, dbPwd);
                break;
            case "JPA" : break;
            default:
                //TODO
                dao = null;
        }
        return dao;
    }

}
