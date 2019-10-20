package dal;

import bo.Player;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class PlayerDAO extends DAO<Player>{
    private static final String AUTHENT_QUERY = "SELECT * FROM player WHERE login = ? AND password = ?";
    private static final String REGISTER_QUERY = "INSERT INTO player (name, login, password) values (?, ?, ?)";

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
                    user.setId(rs.getString("id"));
                    user.setPseudo(rs.getString("name"));
                    user.setLogin( rs.getString( "login" ) );
                    user.setPassword( rs.getString( "password" ) );
                    //user.setNbConnections( rs.getInt( "connections" ) + 1 );
                    //TODO mise à jour du nombre connexions
                }
            }
        }
        return user;
    }

    public Player register( String name, String login, String password) throws SQLException {

        Player player = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd );
        PreparedStatement ps = connection.prepareStatement(REGISTER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, password);
            int i = ps.executeUpdate();
            if (i != 0 ) {
                player = new Player();
                player.setPseudo(name);
                player.setLogin(login);
                player.setPassword(password);
            }
        }  catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return player;
    }
}
