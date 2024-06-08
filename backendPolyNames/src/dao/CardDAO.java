package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyNamesDatabase;
import models.Card;
import models.SelectedCards;

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

    public ArrayList<SelectedCards> chooseCards(){
        ArrayList<SelectedCards> cards = new ArrayList<SelectedCards>();
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            String request = "SELECT * FROM cards ORDER BY RAND() LIMIT 25;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();
            int i = 1;
            while(result.next()){
                String word = result.getString("word");
                String color = "";

                if(1 <= i && i <= 8)
                    color = "blue";
                else if(9 <= i && i <= 23)
                    color = "grey";
                else if(24 <= i && i <= 25)
                    color = "black";

                SelectedCards selectedCard = new SelectedCards(i, word, color);
                cards.add(selectedCard);
                i++;
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public void putChooseCardsInTable(ArrayList<SelectedCards> cards){
        try{
            PolyNamesDatabase database = new PolyNamesDatabase();
            
            database.prepareStatement("DELETE FROM selected_cards;").executeUpdate(); // Supprime les cartes déjà sélectionnées
            
            String request = "INSERT INTO selected_cards (id, word, color) VALUES (?, ?, ?);";
            
            for(SelectedCards card : cards){
                System.out.println(card);
                PreparedStatement statement = database.prepareStatement(request);
                statement.setInt(1, card.id());
                statement.setString(2, card.name());
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
            String request = "SELECT * FROM selected_cards;";

            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                int id = result.getInt("id");
                String word = result.getString("word");
                String color = result.getString("color");

                SelectedCards card = new SelectedCards(id, word, color);
                cards.add(card);
            }

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

}
