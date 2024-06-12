package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.SelectedCards;

public class SelectedCardsDAO {

    public SelectedCardsDAO() {
        
    }


    public ArrayList<SelectedCards> pick25Cards(){
    ArrayList<SelectedCards> cards = new ArrayList<SelectedCards>();

    try{
        PolyNamesDatabase database = new PolyNamesDatabase();
        String request = "SELECT * FROM cards ORDER BY RAND() LIMIT 25;";

        PreparedStatement statement = database.prepareStatement(request);
        ResultSet result = statement.executeQuery();
        int i = 1;

        while(result.next()){
            int card_ID = result.getInt("card_ID");
            String color = "";

            if(1 <= i && i <= 8)
                color = "blue";
            else if(9 <= i && i <= 23)
                color = "grey";
            else if(24 <= i && i <= 25)
                color = "black";

            SelectedCards selectedCard = new SelectedCards(i, card_ID, color, false);
            cards.add(selectedCard);
            i++;
        }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public void putCardsInTable(ArrayList<SelectedCards> cards){
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            
            database.prepareStatement("DELETE FROM selectedcards;").executeUpdate(); // Supprime les cartes déjà sélectionnées
            
            String request = "INSERT INTO selectedcards (id, card_ID, color) VALUES (?, ?, ?);";
            
            for(SelectedCards card : cards){
                System.out.println(card);
                PreparedStatement statement = database.prepareStatement(request);
                statement.setInt(1, card.id());
                statement.setInt(2, card.card_ID());
                statement.setString(3, card.color());
                statement.executeUpdate();
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public ArrayList<SelectedCards> getSelectedCards(){
        ArrayList<SelectedCards> cards = new ArrayList<SelectedCards>();
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT * FROM selectedcards;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int id = result.getInt("id");
                int card_ID = result.getInt("card_ID");
                String color = result.getString("color");

                SelectedCards card = new SelectedCards(id, card_ID, color, false);
                cards.add(card);
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public String getWordById(int card_ID) {
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
