package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Cards;

public class CardsDAO {
    public CardsDAO() {

    }

    public ArrayList<Cards> findAll(){
        ArrayList<Cards> cards = new ArrayList<Cards>();
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT * FROM cards;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int card_ID = result.getInt("card_ID");
                String word = result.getString("word");

                Cards card = new Cards(card_ID, word);
                cards.add(card);
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public String getWordById(int card_ID){
        String word = "";
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            
            String request = "SELECT word FROM cards WHERE card_ID = ?;";
            
            PreparedStatement statement = database.prepareStatement(request);
            
            statement.setInt(1, card_ID);
            ResultSet result = statement.executeQuery();
            result.next();
            word = result.getString("word");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
         
        System.out.println("Word : " + word);
        return word;
    }

}
