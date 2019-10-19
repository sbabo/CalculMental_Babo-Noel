package dal;

import bo.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO extends DAO<Game>{

    private static final String HIGHSCORE_QUERY = "SELECT * FROM game ORDER BY score DESC, date DESC LIMIT 10";

    public GameDAO(String dbUrl, String dbLogin, String dbPwd) {
        super(dbUrl, dbLogin, dbPwd);
    }

    @Override
    public void create(Game objet) {

    }

    @Override
    public List<Game> findAll() {
        return null;
    }

    public List<Game> highscore () throws SQLException {
        List<Game> highscore = new ArrayList<Game>();
        Game game = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd );
             PreparedStatement ps = connection.prepareStatement(HIGHSCORE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                game = new Game();
                game.setPseudo(rs.getString("pseudo"));
                game.setScore(rs.getInt("score"));
                game.setDate(rs.getDate("date"));
                highscore.add(game);
            }
        }  catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return highscore;
    }
}
