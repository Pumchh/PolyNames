package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Cards;

public class CardsDAO {

    int game_ID = GameDAO.getGameIDStatic();

    public CardsDAO() {
        
    }


    public ArrayList<Cards> pick25Cards(){
        ArrayList<Cards> cards = new ArrayList<Cards>();

        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT * FROM words ORDER BY RAND() LIMIT 25;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();
            int i = 1;

            while(result.next()){
                int word_ID = result.getInt("word_ID");
                String color = "";

                if(1 <= i && i <= 8)
                    color = "blue";
                else if(9 <= i && i <= 23)
                    color = "grey";
                else if(24 <= i && i <= 25)
                    color = "black";

                Cards selectedCard = new Cards(i, game_ID, word_ID, color, false);
                cards.add(selectedCard);
                i++;
            }

            }catch(Exception e){
                System.out.println("Error: " + e);
            }
            return cards;
    }

    public void putCardsInTable(ArrayList<Cards> cards){
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            
            database.prepareStatement("DELETE FROM cards;").executeUpdate(); // Supprime les cartes déjà sélectionnées
            
            String request = "INSERT INTO cards (cards_ID, word_ID, color) VALUES (?, ?, ?);";
            
            for(Cards card : cards){
                System.out.println(card);
                PreparedStatement statement = database.prepareStatement(request);
                statement.setInt(1, card.card_ID());
                statement.setInt(2, card.word_ID());
                statement.setString(3, card.color());
                statement.executeUpdate();
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public ArrayList<Cards> getSelectedCards(){
        ArrayList<Cards> cards = new ArrayList<Cards>();
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT * FROM cards;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int id = result.getInt("cards_id");
                int word_ID = result.getInt("word_ID");
                String color = result.getString("color");

                Cards card = new Cards(id, game_ID, word_ID, color, false);
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
            
            String request = "SELECT word FROM words WHERE word_ID = ?;";
            
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
