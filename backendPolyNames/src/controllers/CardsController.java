package controllers;

import java.util.ArrayList;


import dao.CardsDAO;
import models.Cards;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class CardsController {
        public static ArrayList<Cards> pick25Cards(WebServerContext context){
        ArrayList<Cards> cards = new ArrayList<Cards>();

        try{
            WebServerResponse response = context.getResponse();
            CardsDAO selectedCardsDAO = new CardsDAO();

            cards = selectedCardsDAO.pick25Cards();

            response.json(cards);
            response.ok("25 cards selected");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public static void putCardsInTable(WebServerContext context, ArrayList<Cards> cards){
        try{
            
            WebServerResponse response = context.getResponse();
            CardsDAO cardDAO = new CardsDAO();

            cardDAO.putCardsInTable(cards);

            response.ok("25 cards added to the table");

            System.out.println("25 cards added to the table");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<Cards> getSelectedCards(WebServerContext context){
        ArrayList<Cards> cards = new ArrayList<Cards>();

        try{
            WebServerResponse response = context.getResponse();
            CardsDAO selectedCardsDAO = new CardsDAO();

            cards = selectedCardsDAO.getSelectedCards();

            response.json(cards);
            response.ok("Get cards selected");

            System.out.println("Get cards selected");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public static ArrayList<String> getWordsByIds(WebServerContext context, ArrayList<Integer> ids){
        ArrayList<String> words = new ArrayList<String>();

        try{
            WebServerResponse response = context.getResponse();
            CardsDAO selectedCardsDAO = new CardsDAO();

            for(int id : ids){
                words.add(selectedCardsDAO.getWordById(id));
            }

            response.json(words);
            response.ok("Get words selected");

            System.out.println("Get words selected");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return words;
    }

}
