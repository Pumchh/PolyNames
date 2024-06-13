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
}


