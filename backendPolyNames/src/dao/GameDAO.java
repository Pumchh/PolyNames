package dao;

import java.sql.PreparedStatement;
import database.PolyNamesDatabase;


public class GameDAO {
    public GameDAO() {

    }

    public void createGame() {
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "INSERT INTO game (code, score) VALUES (?, ?);";

            PreparedStatement statement = database.prepareStatement(request);
            int randomCode = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
            statement.setString(1, String.valueOf(randomCode));
            statement.setInt(2, 0);
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void updateScore(String code, int score) {
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "UPDATE game SET score = ? WHERE code = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, score);
            statement.setString(2, code);
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public int getScore(String code) {
        int score = 0;
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT score FROM game WHERE code = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setString(1, code);
            score = statement.executeQuery().getInt("score");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return score;
    }

    public void deleteGame(String code) {
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "DELETE FROM game WHERE code = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setString(1, code);
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }


}
