package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.PolyNamesDatabase;

public class RoundDAO {

    int game_ID = GameDAO.getGameIDStatic();

    public RoundDAO() {

    }

    public void createRound() {
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "INSERT INTO round (game_ID) VALUES (?);";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, game_ID);
            statement.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public int getRoundID() {
        int round_ID = 0;
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT round_ID FROM round ORDER BY round_ID DESC LIMIT 1;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                round_ID = statement.getResultSet().getInt("round_ID");
            }
            System.out.println("Round_ID : " + round_ID);
                
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return round_ID;
    }

    public void setHint(String hint){
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "UPDATE round SET hint = ? WHERE round_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setString(1, hint);
            statement.setInt(2, getRoundID());
            statement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void setGuessValue(int guessValue){
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "UPDATE round SET guess_value = ? WHERE round_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, guessValue);
            statement.setInt(2, getRoundID());
            statement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void setRoundScore(int roundScore){
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "UPDATE round SET round_score = ? WHERE round_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, roundScore);
            statement.setInt(2, getRoundID());
            statement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public String getHint(){
        String hint = "";
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT hint FROM round WHERE round_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, getRoundID());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                result.next();
            }
            hint = result.getString("hint");
            System.out.println("Hint : " + hint);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return hint;
    }

    public String getHint(int round_ID){
        String hint = "";
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT hint FROM round WHERE round_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, round_ID);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                result.next();
            }
            
            hint = result.getString("hint");
            System.out.println("Hint : " + hint);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return hint;
    }

    public int getGuessValue(){
        int guessValue = 0;
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT guess_value FROM round WHERE round_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, getRoundID());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                result.next();
            }
                
            guessValue = result.getInt("guess_value");
            System.out.println("GuessValue : " + guessValue);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return guessValue;
    }

    public int getGuessValue(int round_ID){
        int guessValue = 0;
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT guess_value FROM round WHERE round_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, round_ID);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                result.next();
            }
                
            guessValue = result.getInt("guess_value");
            System.out.println("GuessValue : " + guessValue);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return guessValue;
    }

    public int getRoundScore(){
        int roundScore = 0;
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT round_score FROM round WHERE round_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, getRoundID());
            ResultSet result = statement.executeQuery();
            while(result.next()){
                result.next();
            }
                
            roundScore = result.getInt("round_score");
            System.out.println("RoundScore : " + roundScore);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return roundScore;
    }

    public int getRoundScore(int round_ID){
        int roundScore = 0;
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT round_score FROM round WHERE round_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, round_ID);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                result.next();
            }
                
            roundScore = result.getInt("round_score");
            System.out.println("RoundScore : " + roundScore);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return roundScore;
    }


}
