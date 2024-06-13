package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.PolyNamesDatabase;

public class GameDAO {
    public GameDAO() {

    }

    public void createGame() {
        try {
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "INSERT INTO game (hintMaster, wordMaster,score) VALUES ('', '', 0);";

            PreparedStatement statement = database.prepareStatement(request);
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public int getGameID(){
        int game_ID=0;
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT game_ID FROM game ORDER BY game_ID DESC LIMIT 1;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                game_ID = result.getInt("game_ID");
            }
            
            System.out.println(("Game_ID : " + game_ID));


        }catch(Exception e){
            System.out.println("Error: " + e);
        }

        return game_ID;
    }

    public static int getGameIDStatic(){
        int game_ID=0;
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT game_ID FROM game ORDER BY game_ID DESC LIMIT 1;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                game_ID = result.getInt("game_ID");
            }
            
            System.out.println(("Game_ID : " + game_ID));


        }catch(Exception e){
            System.out.println("Error: " + e);
        }

        return game_ID;
    }

    public void setHintMaster(String hintMaster){
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "UPDATE game SET hintMaster = ? WHERE game_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setString(1, hintMaster);
            statement.setInt(2, getGameID());
            statement.executeUpdate();

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public void setWordMaster(String wordMaster){
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "UPDATE game SET wordMaster = ? WHERE game_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setString(1, wordMaster);
            statement.setInt(2, getGameID());
            statement.executeUpdate();

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public String getHintMaster(){
        String hintMaster = "";
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT hintMaster FROM game WHERE game_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, getGameID());
            ResultSet result = statement.executeQuery();

            while(result.next()){
                hintMaster = result.getString("hintMaster");
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }

        return hintMaster;
    }

    public String getWordMaster(){
        String wordMaster = "";
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT wordMaster FROM game WHERE game_ID = ?;";

            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, getGameID());
            ResultSet result = statement.executeQuery();

            while(result.next()){
                wordMaster = result.getString("wordMaster");
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }

        return wordMaster;
    }


}


