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

    /**
     * Recherche d'information pour compléter le tableau de HighScore
     * @return List<Game>
     * @throws SQLException SQLException
     */
    public List<Game> highscore () throws SQLException {
        List<Game> highscore = new ArrayList<Game>();
        Game game = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd ); //essaie connection BDD
             PreparedStatement ps = connection.prepareStatement(HIGHSCORE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = ps.executeQuery(); //Execution requête
            while ( rs.next() ) { //Renseignement des parties retournés
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

    /**
     * Enregistrer le score d'un player en base
     * @param idplayer idplayer
     * @param pseudo pseudo
     * @param score score
     * @param date date
     * @return Game
     * @throws SQLException SQLException
     */
    public Game enregister(int idplayer, String pseudo, int score, String date) throws SQLException {
        Game game = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd ); //essaie de connection BDD
        PreparedStatement ps = connection.prepareStatement(ENREGISTRER_SCORE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, idplayer);
            ps.setString(2, pseudo);
            ps.setInt(3, score);
            ps.setString(4, date);
            int i = ps.executeUpdate(); // execution de requête
            if (i != 0 ) {
                game = new Game();
                game.setPseudo(pseudo);
                game.setScore(score);
                game.setDate(date);
            }
        }  catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return game;
    }

    /**
     * Permet de récupérer un tableau des meilleurs score du joueur
     * @param id_player id-player
     * @return List<Game>
     * @throws SQLException SQLException
     */
    public List<Game> highscore_user(int id_player) throws SQLException {
        List<Game> highscore_player = new ArrayList<Game>();
        Game game = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd ); // essai de connection BDD
             PreparedStatement ps = connection.prepareStatement(USER_HIGHSCORE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt( 1, id_player );
            ResultSet rs = ps.executeQuery(); //execution requete
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
