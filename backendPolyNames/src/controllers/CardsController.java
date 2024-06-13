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
            CardsDAO cardsDAO = new CardsDAO();

            cards = cardsDAO.pick25Cards();

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
            CardsDAO cardsDAO = new CardsDAO();

            cards = cardsDAO.getSelectedCards();

            response.json(cards);
            response.ok("Get cards selected");

            System.out.println("Get cards selected");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return cards;
    }

    public static ArrayList<String> getWords(WebServerContext context){
        ArrayList<String> words = new ArrayList<String>();
        try{
            WebServerResponse response = context.getResponse();
            CardsDAO cardsDAO = new CardsDAO();
            
            words = cardsDAO.getWords();

            response.json(words);
            response.ok("Get words");
            

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return words;
    }

    public static void reveal(WebServerContext context){
        try{
            WebServerResponse response = context.getResponse();
            CardsDAO cardDAO = new CardsDAO();
            
            String idTemp = context.getRequest().getParam("card_ID");
            int card_ID = Integer.parseInt(idTemp);
            System.out.println("Card ID : " + card_ID);

            cardDAO.reveal(card_ID);

            response.ok("Card revealed");

            System.out.println("Card revealed");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static boolean getIsRevealed(WebServerContext context){
        boolean isRevealed = false;

        try{
            WebServerResponse response = context.getResponse();
            CardsDAO cardDAO = new CardsDAO();

            String idTemp = context.getRequest().getParam("card_ID");
            int card_ID = Integer.parseInt(idTemp);
            System.out.println("Card ID : " + card_ID);

            isRevealed = cardDAO.getIsRevealed(card_ID);

            response.json(isRevealed);
            response.ok("Card revealed");

            System.out.println("Card revealed");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return isRevealed;
    }

}
