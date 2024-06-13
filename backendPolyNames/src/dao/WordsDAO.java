package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Words;

public class WordsDAO {
    public WordsDAO() {

    }

    public ArrayList<Words> findAll(){
        ArrayList<Words> cards = new ArrayList<Words>();
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT * FROM words;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int card_ID = result.getInt("word_ID");
                String word = result.getString("word");

                Words card = new Words(card_ID, word);
                cards.add(card);
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public String getWordById(int word_ID){
        String word = "";
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            
            String request = "SELECT word FROM words WHERE word_ID = ?;";
            
            PreparedStatement statement = database.prepareStatement(request);
            
            statement.setInt(1, word_ID);
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
