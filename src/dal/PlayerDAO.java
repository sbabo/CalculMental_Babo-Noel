package dal;

import bo.Player;

import java.sql.*;
import java.util.List;

public class PlayerDAO extends DAO<Player>{
    private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";

    public PlayerDAO( String dbUrl, String dbLogin, String dbPwd ) {
        super( dbUrl, dbLogin, dbPwd );
    }

    @Override
    public void create( Player objet ) {

    }

    @Override
    public List<Player> findAll() {
        return null;
    }

    public Player authenticate( String login, String password ) throws SQLException {

        Player user = null;
        try (Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
             PreparedStatement ps = connection.prepareStatement(AUTHENT_QUERY) ) {
            ps.setString( 1, login );
            ps.setString( 2, password );
            try ( ResultSet rs = ps.executeQuery() ) {
                if ( rs.next() ) {
                    user = new Player();
                    user.setLogin( rs.getString( "login" ) );
                    user.setPassword( rs.getString( "password" ) );
                    //user.setNbConnections( rs.getInt( "connections" ) + 1 );
                    //TODO mise à jour du nombre connexions
                }
            }
        }
        return user;
    }
}
