package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Card;

public class CardDAO {
    public CardDAO() {

    }

    public ArrayList<Card> findAll(){
        ArrayList<Card> cards = new ArrayList<Card>();
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT * FROM cards;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int id = result.getInt("id");
                String word = result.getString("word");

                Card card = new Card(id, word);
                cards.add(card);
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }

        return cards;

    }

}
