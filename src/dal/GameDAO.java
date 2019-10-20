package dal;

import bo.Game;
import bo.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO extends DAO<Game>{

    private static final String USER_HIGHSCORE_QUERY = "SELECT * FROM game WHERE id_player = ? ORDER BY date DESC LIMIT 1";
    private static final String HIGHSCORE_QUERY = "SELECT * FROM game ORDER BY score DESC, date DESC LIMIT 10";
    private static final String ENREGISTRER_SCORE_QUERY = "INSERT INTO game (id_player, pseudo, score, date) values (?, ?, ?, ?)";

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
                game.setDate(rs.getString("date"));
                highscore.add(game);
            }
        }  catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return highscore;
    }

    public Game enregister(int idplayer, String pseudo, int score, String date) throws SQLException {
        Game game = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd );
        PreparedStatement ps = connection.prepareStatement(ENREGISTRER_SCORE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, idplayer);
            ps.setString(2, pseudo);
            ps.setInt(3, score);
            ps.setString(4, date);
            int i = ps.executeUpdate();
            if (i != 0 ) {
                game = new Game();
                game.setPseudo(pseudo);
                game.setScore(score);
                game.setDate(date);
            }
            ps.executeUpdate();
        }  catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return game;
    }

    public List<Game> highscore_user(int id_player) throws SQLException {
        List<Game> highscore_player = new ArrayList<Game>();
        Game game = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd );
             PreparedStatement ps = connection.prepareStatement(USER_HIGHSCORE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt( 1, id_player );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                game = new Game();
                game.setPseudo(rs.getString("pseudo"));
                game.setScore(rs.getInt("score"));
                game.setDate(rs.getString("date"));
                highscore_player.add(game);
            }
        }  catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return highscore_player;
    }
}
